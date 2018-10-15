package com.newmind.seobackstage.common.lambda;

@FunctionalInterface
public interface IAction<T> {
    void run(T param);
}
