package com.sqlServer.executor;

public interface Executor<T, E> {
    T execute(E e);
}
