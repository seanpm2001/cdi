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

package jakarta.enterprise.event;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.inject.spi.Extension;

/**
 * <p>
 * Identifies the event parameter of an observer method. May be applied to a parameter of a method of a bean class or
 * {@linkplain Extension extension}.
 * </p>
 * 
 * <pre>
 * public void afterLogin(&#064;Observes LoggedInEvent event) { ... }
 * </pre>
 * 
 * <p>
 * An observer method is a non-abstract method of a managed bean class or session bean class (or of an extension). An observer
 * method may be either static or non-static. If the bean is a session bean, the observer method must be either a business
 * method of the EJB or a static method of the bean class.
 * </p>
 * 
 * <p>
 * Each observer method must have exactly one event parameter, of the same type as the event type it observes. Event qualifiers
 * may be declared by annotating the event parameter. When searching for observer methods for an event, the container considers
 * the type and qualifiers of the event parameter.
 * </p>
 * 
 * <p>
 * If the event parameter does not explicitly declare any qualifier, the observer method observes events with no qualifier.
 * </p>
 * 
 * <p>
 * The event parameter type may contain a type variable or wildcard.
 * </p>
 * 
 * <p>
 * In addition to the event parameter, observer methods may declare additional parameters, which may declare qualifiers. These
 * additional parameters are injection points.
 * </p>
 * 
 * <pre>
 * public void afterLogin(&#064;Observes LoggedInEvent event, &#064;Manager User user, Logger log) { ... }
 * </pre>
 * 
 * <p>
 * A bean (or extension) may declare multiple observer methods.
 * </p>
 * 
 * <p>
 * Observer methods are inherited by bean subclasses.
 * </p>
 * 
 * <p>
 * Interceptors and decorators may not declare observer methods.
 * </p>
 * 
 * @author Gavin King
 * @author Pete Muir
 * @author David Allen
 */

@Target(PARAMETER)
@Retention(RUNTIME)
@Documented
public @interface Observes {
    /**
     * <p>
     * Specifies {@linkplain Reception under what conditions the observer method is notified}.
     * </p>
     * 
     * <p>
     * By default, the observer method is notified even if no instance of the bean that defines the observer method already
     * exists in the current context.
     * </p>
     * @return conditional observer type
     */
    public Reception notifyObserver() default Reception.ALWAYS;

    /**
     * <p>
     * Specifies {@linkplain Reception at what time the observer method is notified}.
     * </p>
     * 
     * <p>
     * By default, the observer method is notified when the event is fired.
     * </p>
     * @return phase of the transaction
     */
    public TransactionPhase during() default TransactionPhase.IN_PROGRESS;
}
