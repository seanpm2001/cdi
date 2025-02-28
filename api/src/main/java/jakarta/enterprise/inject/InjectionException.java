/*
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jakarta.enterprise.inject;

/**
 * Indicates a problem relating to dependency injection.
 * 
 * @author Pete Muir
 */
public class InjectionException extends RuntimeException {

    private static final long serialVersionUID = -2132733164534544788L;

    public InjectionException() {
    }

    public InjectionException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InjectionException(String message) {
        super(message);
    }

    public InjectionException(Throwable throwable) {
        super(throwable);
    }

}
