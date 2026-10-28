package com.ecommerce.speculative;

public abstract class AbstractGenericEntityProcessorFactory<T, U, V, W> {
    public abstract IGenericProcessor<T, U, V, W> createProcessor(String processorType);
    
    public void registerProcessorHook(String hookName, Object hookBehavior) {
    }
    
    public abstract boolean isProcessorAvailable(String processorType);
}