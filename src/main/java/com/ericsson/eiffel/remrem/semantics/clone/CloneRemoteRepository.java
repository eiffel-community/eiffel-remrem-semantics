package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;

/**
 * Simple snippet which shows how to clone a repository from a remote source
 *
 * @author dominik.stadler at gmx.at
 */

public class CloneRemoteRepository {

	static String propertyFile = "config.properties";
	static Properties prop = new Properties();
	private static String homeDir = System.getProperty("user.home");
	private static String cwd = System.getProperty("user.dir");
	private static File localPath;

	public static ArrayList<String> fileNames;
	private static HashMap<String, File> globalFiles;
	
	/* To read the properties from config.properties file */
	public static Properties getPropertiesFromFile() {
		try {
			InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFile);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/* 
	 * To clone eiffel repo topic-drop4 branch form github
	 * */
	public static void cloneRemoteRepo() {
		localPath = new File(homeDir + "\\" + prop.getProperty("repoName"));
		try {
			System.out.println("Latest Schema's Updating...");
			FileUtils.cleanDirectory(new File(cwd + "\\" + prop.getProperty("inputSchemas")));
			if (!localPath.exists()) {
				Git.cloneRepository().setURI(prop.getProperty("remoteURL")).setBranch(prop.getProperty("branch"))
						.setDirectory(localPath).call();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		fileNames = new ArrayList<String>();
		globalFiles = new HashMap<String, File>();
		String filepath = localPath + "\\schemas";
		callResursiveFiles(filepath, "");
	}

	/*
	 * To rename the files with directory name used to generate event classes with that name
	 */
	public static void callResursiveFiles(String fileName, String name) {
		File file = new File(fileName);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					callResursiveFiles(f.getAbsolutePath(), f.getName());
				} else {
					fileNames.add(name);
					globalFiles.put(name, f);
				}
			}
		} else {
			fileNames.add(name);
			globalFiles.put(name, file);
		}
		callArrayListFiles();
	}
	/*
	 * To place all files in list to generate enum constants in Meta
	 * */
	private static void callArrayListFiles() {
		Iterator<String> iter = fileNames.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			File file = globalFiles.get(name);
			ChangeProperties.modifyFileContent(file, name);
		}

	}

	public static void main(String[] args) throws IOException {
		CloneRemoteRepository.getPropertiesFromFile();
		CloneRemoteRepository.cloneRemoteRepo();

	}

}