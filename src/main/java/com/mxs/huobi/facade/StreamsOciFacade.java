package com.mxs.huobi.facade;

import com.mxs.huobi.request.SendMessageOciStreamsRequest;
import com.mxs.huobi.response.SendMessageOciStreamsResponse;
import com.mxs.huobi.strategy.oci.ProducerOciStreamsStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamsOciFacade {
    private static final Logger logger = LoggerFactory.getLogger(StreamsOciFacade.class);
    @Autowired
    private ProducerOciStreamsStrategy producerOciStreamsStrategy;

    public SendMessageOciStreamsResponse sendMessage(SendMessageOciStreamsRequest sendMessageOciStreamsRequest) {
        logger.info("StreamsOciFacade.sendMessage - sendMessageOciStreamsRequest: {}", sendMessageOciStreamsRequest);
        SendMessageOciStreamsResponse sendMessageOciStreamsResponse = producerOciStreamsStrategy.sendMessage(sendMessageOciStreamsRequest);
        logger.info("StreamsOciFacade.sendMessage - sendMessageOciStreamsResponse: {}", sendMessageOciStreamsResponse);
        return sendMessageOciStreamsResponse;
    }
}
