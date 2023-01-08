package com.mxs.huobi.strategy.oci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.mxs.huobi.constant.OciStreamsTopicConstant.PURCHASE_ANALYSIS;

@Service
public class ConsumerStreamsOciStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerStreamsOciStrategy.class);
    @KafkaListener(topics = PURCHASE_ANALYSIS, groupId = "purchase_analysis_consumer")
    public void consumeMessage(String message) {
        logger.info("ConsumerStreamsOciStrategy.consumeMessage - Message: {}", message);
    }
}
