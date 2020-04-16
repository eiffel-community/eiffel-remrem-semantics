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
package com.ericsson.eiffel.remrem.semantics;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ValidationTest {

    JsonParser parser = new JsonParser();
    @Test
    public void testValidEventOutput() {
        try {
            File file = new File("src/test/resources/output");
            if (file.exists()) {
                for (File inputFile : file.listFiles()) {
                    JsonObject object = parser.parse(new FileReader(inputFile)).getAsJsonObject();
                    String msgType = object.get("meta").getAsJsonObject().get("type").getAsString();
                    EiffelValidator validator = EiffelOutputValidatorFactory
                            .getEiffelValidator(EiffelEventType.fromString(msgType));
                    validator.validate(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }
    }

    @Test(expected = EiffelValidationException.class)
    public void TestInvalidActivityFinishedOutput() throws Exception {
            URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
            String path = url.getPath().replace("%20", " ");
            File file = new File(path);
            JsonObject jsonObject = parser.parse(new FileReader(file)).getAsJsonObject();
            EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_FINISHED);
            jsonObject.remove("data");
            validator.validate(jsonObject);
        
    }

    @Test
    public void TestEventwithCauseAndContextLinkTypes() throws Exception {
        try {
            File file = new File("output/TriggeredwithCauseAndContext.json");
            if (file.exists()) {
                JsonObject object = parser.parse(new FileReader(file)).getAsJsonObject();
                String msgType = object.get("meta").getAsJsonObject().get("type").getAsString();
                EiffelValidator validator = EiffelOutputValidatorFactory
                        .getEiffelValidator(EiffelEventType.fromString(msgType));
                validator.validate(object);
                validator.customValidation(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }
    }
}