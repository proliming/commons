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
package com.proliming.commons.utils;

/**
 * Exception thrown upon the failure of a
 * verification check, including those performed by the convenience
 * methods of the {@link Verify} class.
 */

public class VerifyException extends RuntimeException {
    /**
     * Constructs a {@code VerifyException} with no message.
     */
    public VerifyException() {
    }

    /**
     * Constructs a {@code VerifyException} with the message {@code message}.
     */
    public VerifyException(String message) {
        super(message);
    }

    /**
     * Constructs a {@code VerifyException} with the message {@code message} and the cause
     * {@code cause}.
     */

    public VerifyException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code VerifyException} with the message {@code message} and the cause
     * {@code cause}.
     */
    public VerifyException(String message, Throwable cause) {
        super(message, cause);
    }

}
