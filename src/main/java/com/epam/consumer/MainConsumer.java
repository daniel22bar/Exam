package com.epam.consumer;

import com.epam.consumer.flow.QuoterConsumerFlowManager;
import com.epam.consumer.services.JavaRepeatEveryX;
import com.epam.infra.ApplicationContext;
import com.epam.infra.JavaConfig;


public class MainConsumer {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(JavaConfig.builder().packagesToScan("com.epam").build());
        QuoterConsumerFlowManager flowManager = context.getObject(QuoterConsumerFlowManager.class);

        JavaRepeatEveryX repeatEveryX = context.getObject(JavaRepeatEveryX.class);
        repeatEveryX.timerTaskWrapper(()->flowManager.consumeQuotes());
    }
}
