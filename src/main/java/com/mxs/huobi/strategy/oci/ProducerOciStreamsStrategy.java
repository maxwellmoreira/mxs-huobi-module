package com.mxs.huobi.strategy.oci;

import com.mxs.huobi.factory.OciStreamsFactory;
import com.mxs.huobi.request.SendMessageOciStreamsRequest;
import com.mxs.huobi.response.SendMessageOciStreamsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

import static com.mxs.huobi.constant.OciStreamsTopicConstant.PURCHASE_ANALYSIS;

@Service
public class ProducerOciStreamsStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ProducerOciStreamsStrategy.class);
    @Autowired
    private OciStreamsFactory ociStreamsFactory;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public SendMessageOciStreamsResponse sendMessage(SendMessageOciStreamsRequest sendMessageOciStreamsRequest) {
        UUID key = UUID.randomUUID();
        logger.info("StreamsProducerOciStrategy.sendMessage - Topic: {}, Key: {}, Value: {} ",
                PURCHASE_ANALYSIS, key, sendMessageOciStreamsRequest.getValue());
        ListenableFuture<SendResult<String, String>> listenableFutureSendResult =
                kafkaTemplate.send(PURCHASE_ANALYSIS, key.toString(), sendMessageOciStreamsRequest.getValue());
        listenableFutureSendResult.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                logger.info("ProducerOciStreamsStrategy.sendMessage - Message sent successfully! Topic: {}, Partition: {}, Offset: {}, Timestamp: {}",
                        sendResult.getRecordMetadata().topic(), sendResult.getRecordMetadata().partition(),
                        sendResult.getRecordMetadata().offset(), sendResult.getRecordMetadata().timestamp());

            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("ProducerOciStreamsStrategy.sendMessage - An error occurred while processing the message. Message: {}, Cause: {}",
                        throwable.getMessage(), throwable.getCause());
            }
        });
        return SendMessageOciStreamsResponse.builder().key(key.toString()).build();
    }
}
