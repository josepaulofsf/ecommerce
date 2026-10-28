package com.ecommerce.speculative;

public interface IGenericProcessor<T, U, V, W> {
    W processEntityPhaseOne(T entity, U context);
    W processEntityPhaseTwo(T entity, V context);
    void rollbackProcess(W processResult);
}