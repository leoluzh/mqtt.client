package com.lambdasys.iot.mqtt.client.consumer;

import java.util.Objects;

@FunctionalInterface
public interface Consumer4<T,U,V,X> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t, U u , V v, X x);

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default Consumer4<T,U,V,X> andThen(Consumer4<? super T, ? super U, ? super V, ? super X> after) {
        Objects.requireNonNull(after);
        return (T t, U u, V v, X x) -> { accept(t,u,v,x); after.accept(t,u,v,x); };
    }
	
	
}
