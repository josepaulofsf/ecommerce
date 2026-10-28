package com.ecommerce.speculative;

import org.springframework.stereotype.Component;

@Component
public class SimpleOrderProcessor extends AbstractGenericEntityProcessorFactory<Object, Object, Object, Object> {

    @Override
    public IGenericProcessor<Object, Object, Object, Object> createProcessor(String processorType) {
        return new IGenericProcessor<Object, Object, Object, Object>() {
            @Override
            public Object processEntityPhaseOne(Object entity, Object context) {
                return null;
            }

            @Override
            public Object processEntityPhaseTwo(Object entity, Object context) {
                return null;
            }

            @Override
            public void rollbackProcess(Object processResult) {
            }
        };
    }

    @Override
    public boolean isProcessorAvailable(String processorType) {
        return true;
    }
}