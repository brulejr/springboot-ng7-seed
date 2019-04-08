/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Jon Brule <brulejr@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package io.jrb.labs.common.validation;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Collection;
import java.util.Optional;

public interface Assert {

    static final String GREATER_THAN = "%s must be greater than %s";

    static final String IS_NULL = "%s must be null";

    static final String IS_PRESENT = "%s must be present";

    static final String MIN_LENGTH = "%s must have a minimum number of %s items";

    static final String NOT_NULL = "%s cannot be null";

    static final String NOT_BLANK = "%s cannot be blank";

    static final String NOT_EMPTY = "%s cannot be empty";

    static final String REQUIRED = "%s is required";

    static int greaterThan(final int value, final int expected, final String name) {
        checkArgument(value > expected, GREATER_THAN, name, expected);
        return value;
    }

    static long greaterThan(final long value, final long expected, final String name) {
        checkArgument(value > expected, GREATER_THAN, name, expected);
        return value;
    }

    static <T> T isNull(final T value, final String name) {
        checkArgument(value == null, IS_NULL, name);
        return value;
    }

    static <T> T isPresent(final Optional<T> value, final String name) {
        checkArgument(value != null, NOT_NULL, name);
        checkArgument(value.isPresent(), IS_PRESENT, name);
        return value.get();
    }

    static <T> T[] minLength(final T[] value, final int length, final String name) {
        checkArgument(value != null && value.length > 0, MIN_LENGTH, name, length);
        return value;
    }

    static String notBlank(final String value, final String name) {
        checkArgument(value != null && value.length() > 0, NOT_BLANK, name);
        return value;
    }

    static <T extends Collection<?>> T notEmpty(final T value, final String name) {
        checkArgument(value != null && value.size() > 0, NOT_EMPTY, name);
        return value;
    }

    static <T> T notNull(final T value, final String name) {
        checkArgument(value != null, NOT_NULL, name);
        return value;
    }

    static <T> T required(final T value, final String name) {
        checkArgument(value != null, REQUIRED, name);
        return value;
    }

}
