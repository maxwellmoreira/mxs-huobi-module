package com.mxs.huobi.controller;

import com.mxs.huobi.facade.StreamsOciFacade;
import com.mxs.huobi.request.SendMessageOciStreamsRequest;
import com.mxs.huobi.response.SendMessageOciStreamsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.mxs.huobi.constant.BaseUriConstant.OCI_STREAMS;

@Controller
@RequestMapping(OCI_STREAMS)
public class OciStreamsController {
    private static final Logger logger = LoggerFactory.getLogger(OciStreamsController.class);
    @Autowired
    private StreamsOciFacade streamsOciFacade;

    @PostMapping
    public ResponseEntity<SendMessageOciStreamsResponse> sendMessage(@Valid @RequestBody SendMessageOciStreamsRequest sendMessageOciStreamsRequest) {
        logger.info("StreamsOciController.sendMessage - sendMessageOciStreamsRequest: {}", sendMessageOciStreamsRequest);
        SendMessageOciStreamsResponse sendMessageOciStreamsResponse = streamsOciFacade.sendMessage(sendMessageOciStreamsRequest);
        logger.info("StreamsOciController.sendMessage - sendMessageOciStreamsResponse: {}", sendMessageOciStreamsResponse);
        return ResponseEntity.ok(sendMessageOciStreamsResponse);
    }
}
