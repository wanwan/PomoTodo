/*
 *  Copyright 2011 www.juancarlosfernadez.net
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package net.juancarlosfernandez.pomotodo.toodledo.response;

import net.juancarlosfernandez.pomotodo.toodledo.error.ToodledoError;
import net.juancarlosfernandez.pomotodo.toodledo.exception.ToodledoApiException;
import net.juancarlosfernandez.pomotodo.toodledo.xml.ErrorParser;

public abstract class Response {
    protected String response;
    protected ToodledoError error = null;

    public Response(String response) {
        this.response = response;
        ErrorParser errorParser = new ErrorParser(response);
        error = errorParser.getError();
    }

    public String getXmlResponseContent() throws ToodledoApiException {

        if (error != null)
            throw new ToodledoApiException(error.getMessage());

        return this.response;
    }
}
