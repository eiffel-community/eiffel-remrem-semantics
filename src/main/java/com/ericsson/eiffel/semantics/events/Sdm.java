/*******************************************************************************
 * Copyright 2018 Ericsson AB.
 * For a full list of individual contributors, please see the commit history.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sdm {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@SerializedName("authorIdentity")
	@Expose
	private String authorIdentity;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@SerializedName("encryptedDigest")
	@Expose
	private String encryptedDigest;

	/**
	 * 
	 * (Required)
	 * 
	 */
	public String getAuthorIdentity() {
		return authorIdentity;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	public void setAuthorIdentity(String authorIdentity) {
		this.authorIdentity = authorIdentity;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	public String getEncryptedDigest() {
		return encryptedDigest;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	public void setEncryptedDigest(String encryptedDigest) {
		this.encryptedDigest = encryptedDigest;
	}

}
