package com.wxhao.boot.base.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 对象处理
 *
 * @author wxhao
 * @date 2018/4/14
 */
public class Relaxed<T> {

    private static final Relaxed<?> EMPTY = new Relaxed<>();

    private final T value;

    private Relaxed() {
        this.value = null;
    }

    private Relaxed(T obj) {
        this.value = obj;
    }

    public static <T> Relaxed<T> empty() {
        Relaxed<T> t = (Relaxed<T>) EMPTY;
        return t;
    }

    public static <T> Relaxed<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public static <T> Relaxed<T> of(T value) {
        return new Relaxed<>(value);
    }

    public boolean isNull() {
        return this.value == null;
    }

    public boolean isNotNull() {
        return !isNull();
    }

    public void isNullThrow() {
        if (isNull()) {
            throw new NullPointerException();
        }
    }

    public <E extends RuntimeException> void isNullThrow(E e) {
        if (isNull()) {
            throw e;
        }
    }

    public void ifNotNull(Consumer<? super T> consumer) {
        if (isNotNull()) {
            consumer.accept(value);
        }
    }

    public <U> Relaxed<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (isNull()) {
            return empty();
        }
        return Relaxed.ofNullable(mapper.apply(value));

    }

    public T get() {
        return value;
    }

}
