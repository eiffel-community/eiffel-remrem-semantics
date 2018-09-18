/*
    Copyright 2018 Ericsson AB.
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
package com.ericsson.eiffel.semantics.events;

import java.util.List;

public interface Meta {

	/**
	 * set event id
	 * 
	 * @param id
	 */
	public void setId(String id);

	/**
	 * set time when event generate/create
	 * 
	 * @param time
	 */
	public void setTime(Long time);

	/**
	 * set source information to event
	 * 
	 * @param source
	 */
	public void setSource(Source source);

	/**
	 * Get the EventId
	 * 
	 * @return string of UUID
	 */
	public String getId();

	/**
	 * Get the type/name of the event
	 * 
	 * @return
	 */
	public Object getType();

	/**
	 * Get the version of the event Eiffel semantics follow the Semantic Versioning
	 * 2.0.0 for version declaration
	 * 
	 * @return
	 */
	public Object getVersion();

	/**
	 * get the event generated time in long format
	 * 
	 * @return
	 */
	public Long getTime();

	/**
	 * get the tags
	 * 
	 * @return
	 */
	public List<String> getTags();

	/**
	 * get the source of event
	 * 
	 * @return
	 */
	public Source getSource();

	/**
	 * get the security
	 * 
	 * @return
	 */
	public Security getSecurity();
}
