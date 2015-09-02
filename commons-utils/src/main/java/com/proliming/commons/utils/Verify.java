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
 * Static convenience methods that serve the same purpose as Java
 * language assertions, except that they are always enabled.
 */
public /*final*/ class Verify {

    /**
     * Ensures the truth of an expression.
     *
     * @param expression a boolean expression
     *
     * @throws VerifyException if {@code expression} is false
     */
    public static void isTrue(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures the false of an expression.
     *
     * @param expression a boolean expression
     *
     * @throws VerifyException if {@code expression} is true
     */
    public static void isFalse(boolean expression) {
        isTrue(!expression);
    }

    /**
     * Ensures the truth of an expression.
     *
     * @param expression   a boolean expression
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     *                     string using {@link String#valueOf(Object)}
     *
     * @throws VerifyException if {@code expression} is false
     */
    public static void verify(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new VerifyException(String.valueOf(errorMessage));
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression           a boolean expression
     * @param errorMessageTemplate a template for the exception message should the check fail. The
     *                             message is formed by replacing each {@code %s} placeholder in the template with an
     *                             argument. These are matched by position - the first {@code %s} gets {@code
     *                             errorMessageArgs[0]}, etc.  Unmatched arguments will be appended to the formatted
     *                             message
     *                             in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs     the arguments to be substituted into the message template. Arguments
     *                             are converted to strings using {@link String#valueOf(Object)}.
     *
     * @throws VerifyException if {@code expression} is false
     * @throws VerifyException if the check fails and either {@code errorMessageTemplate} or
     *                         {@code errorMessageArgs} is null (don't let this happen)
     */
    public static void verify(
            boolean expression,
            String errorMessageTemplate,
            Object... errorMessageArgs) {
        if (!expression) {
            throw new VerifyException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * Verify that an object is {@code null} .
     * <pre class="code">Verify.isNull(value);</pre>
     *
     * @param object the object to check
     *
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    /**
     * Verify that an Object is {@code null} .
     * <pre class="code">Verify.isNull(value, "The value must be null");</pre>
     *
     * @param obj     the reference to check
     * @param message the exception message to use if the assertion fails
     *
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw new IllegalArgumentException(message);
        }

    }

    /**
     * Ensures that {@code reference} is non-null, throwing a {@code VerifyException} with a default
     * message otherwise.
     *
     * @return {@code reference}, guaranteed to be non-null, for convenience
     *
     * @throws VerifyException if {@code reference} is {@code null}
     */
    public static <T> T notNull(T reference) {
        return notNull(reference, "expected a non-null reference");
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference    an object reference
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     *                     string using {@link String#valueOf(Object)}
     *
     * @return the non-null reference that was validated
     *
     * @throws VerifyException if {@code reference} is null
     */
    public static <T> T notNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new VerifyException(String.valueOf(errorMessage));
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference            an object reference
     * @param errorMessageTemplate a template for the exception message should the check fail. The
     *                             message is formed by replacing each {@code %s} placeholder in the template with an
     *                             argument. These are matched by position - the first {@code %s} gets {@code
     *                             errorMessageArgs[0]}, etc.  Unmatched arguments will be appended to the formatted
     *                             message
     *                             in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs     the arguments to be substituted into the message template. Arguments
     *                             are converted to strings using {@link String#valueOf(Object)}.
     *
     * @return the non-null reference that was validated
     *
     * @throws VerifyException if {@code reference} is null
     */
    public static <T> T notNull(
            T reference, String errorMessageTemplate, Object... errorMessageArgs) {
        if (reference == null) {
            // If either of these parameters is null, the right thing happens anyway
            throw new VerifyException(format(errorMessageTemplate, errorMessageArgs));
        }
        return reference;
    }

    /**
     * Substitutes each {@code %s} in {@code template} with an argument. These are matched by
     * position: the first {@code %s} gets {@code args[0]}, etc.  If there are more arguments than
     * placeholders, the unmatched arguments will be appended to the end of the formatted message in
     * square braces.
     *
     * @param template a non-null string containing 0 or more {@code %s} placeholders.
     * @param args     the arguments to be substituted into the message template. Arguments are converted
     *                 to strings using {@link String#valueOf(Object)}. Arguments can be null.
     */
    static String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }

}
