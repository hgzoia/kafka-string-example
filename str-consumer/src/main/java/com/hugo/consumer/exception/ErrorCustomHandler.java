package com.hugo.consumer.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("EXCEPTION_HANDLER ::: Captured an error.");
        log.info("PAYLOAD ::: {}", message.getPayload());
        log.info("HEADERS ::: {}", message.getHeaders());
        log.info("OFFSET ::: {}", message.getHeaders().get("kafka_offset"));
        log.info("MESSAGE EXCEPTION ::: {}", e.getMessage());
        return null;
    }

}
