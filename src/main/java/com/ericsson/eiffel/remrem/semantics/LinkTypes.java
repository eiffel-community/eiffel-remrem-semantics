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
package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;

public enum LinkTypes {

    CAUSE(EiffelConstants.MULTIPLE_ALLOWED),
    CONTEXT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    FLOW_CONTEXT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    ACTIVITY_EXECUTION(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    PREVIOUS_ACTIVITY_EXECUTION(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    PREVIOUS_VERSION(EiffelConstants.MULTIPLE_ALLOWED),
    COMPOSITION(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    ENVIRONMENT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    ARTIFACT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    SUBJECT(EiffelConstants.MULTIPLE_ALLOWED),
    ELEMENT(EiffelConstants.MULTIPLE_ALLOWED),
    BASE(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    CHANGE(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    TEST_SUITE_EXECUTION(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    TEST_CASE_EXECUTION(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    IUT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    TERC(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    MODIFIED_ANNOUNCEMENT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    SUB_CONFIDENCE_LEVEL(EiffelConstants.MULTIPLE_ALLOWED),
    REUSED_ARTIFACT(EiffelConstants.MULTIPLE_NOT_ALLOWED),
    VERIFICATION_BASIS(EiffelConstants.MULTIPLE_ALLOWED);

    private final boolean multipleAllowed;   

    LinkTypes(boolean multipleAllowed) {
       this.multipleAllowed = multipleAllowed;
   }

   public boolean isMultipleAllowed() {
       return multipleAllowed;
   }
}
