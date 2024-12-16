package com.enduser.enduser.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {
    
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics= AppConstants.LOCATION_UPDATE_TOPIC,groupId=AppConstants.GROUP_ID)
    public void updatedLocation(String value){
        logger.info(value);
    }
}
