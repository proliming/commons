/*
 * Copyright (c) the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proliming.commons.lang;

/**
 * <p>
 * The Builder interface is designed to designate a class as a <em>builder</em>
 * object in the Builder design pattern. Builders are capable of creating and
 * configuring objects or results that normally take multiple steps to construct
 * or are very complex to derive.
 * </p>
 * <p/>
 * <p>
 * The builder interface defines a single method, {@link #build()}, that
 * classes must implement. The result of this method should be the final
 * configured object or result after all building operations are performed.
 * </p>
 * <p/>
 * <p>
 * It is a recommended practice that the methods supplied to configure the
 * object or result being built return a reference to {@code this} so that
 * method calls can be chained together.
 * </p>
 */
public interface Builder<T> {

    /**
     * Returns a reference to the object being constructed or result being
     * calculated by the builder.
     *
     * @return the object constructed or result calculated by the builder.
     */
    T build();
}
