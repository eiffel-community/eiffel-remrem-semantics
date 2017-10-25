/*
    Copyright 2017 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.ericsson.eiffel.remrem.semantics.util;

import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.semantics.SemanticsService;
import com.ericsson.eiffel.semantics.events.Gav;

public class ManifestHandler {
	public static final Logger log = LoggerFactory.getLogger(SemanticsService.class);

	/**
	 * This method is used to read semantics GAV from MANIFEST.MF file
	 * 
	 * @return Gav instance which contains semantics gav read from MANIFEST.MF file
	 */
	public Gav readGavfromManifest() {
		try {
			Gav semanticsGAV = new Gav();
			String classPath = SemanticsService.class.getResource("SemanticsService.class").toString();
			String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
			Manifest manifest = new Manifest(new URL(manifestPath).openStream());
			Attributes attributes = manifest.getMainAttributes();
			semanticsGAV.setGroupId(attributes.getValue("groupId"));
			semanticsGAV.setArtifactId(attributes.getValue("artifactId"));
			semanticsGAV.setVersion(attributes.getValue("semanticsVersion"));
			return semanticsGAV;
		} catch (Exception e) {
			log.error("Unable to read eiffel-remrem-semantics gav information from MANIFEST.MF " + e.getMessage());
		}
		return null;
	}
}
