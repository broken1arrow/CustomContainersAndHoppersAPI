package org.brokenarrow.storage.api.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a function that accepts two arguments and produces a result.
 * This is the two-arity specialization of {@link Function}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object)}.
 *
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function and the result.
 * @see Function
 * @since 1.8
 */
public interface BiModifier<T, U> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     */
    U apply(T t, U u);

    default BiModifier<T, U> andThen(BiModifier<? super T, U> after) {
        Objects.requireNonNull(after);
        return (t, u) -> after.apply(t, apply(t, u));
    }
}
