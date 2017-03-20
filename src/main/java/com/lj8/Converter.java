package com.lj8;


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
