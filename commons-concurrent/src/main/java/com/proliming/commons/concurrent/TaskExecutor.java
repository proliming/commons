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
package com.proliming.commons.concurrent;

import java.util.concurrent.Executor;

/**
 * <p/>
 * Simple task executor interface that abstracts the execution
 * of a {@link Runnable}.
 * <p>Implementations can use all sorts of different execution strategies,
 * such as: synchronous, asynchronous, using a thread pool, and more.
 */
public interface TaskExecutor extends Executor {

    /**
     * Execute the given {@code task}.
     * <p>The call might return immediately if the implementation uses
     * an asynchronous execution strategy, or might block in the case
     * of synchronous execution.
     *
     * @param task the {@code Runnable} to execute (never {@code null})
     *
     * @throws TaskRejectedException if the given task was not accepted
     */
    @Override
    void execute(Runnable task);

}
