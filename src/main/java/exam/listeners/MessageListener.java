package exam.listeners;

import exam.generators.StatementGenerator;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class MessageListener {

    @Autowired
    private StatementGenerator statementGenerator;

    @RabbitListener(queues = "queue_recovery")
    public Message onRecoveryPdfMessage(Message message) {
        try {
            Map<String, Object> fileParams = (Map<String, Object>) SerializationUtils.deserialize(message.getBody());
            byte[] content = statementGenerator.pdfRecoveryGenerating(fileParams);
            return new Message(content);
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @RabbitListener(queues = "queue_academic_leave")
    public Message onAcademicLeavePdfMessage(Message message){
        try {
            Map<String, Object> fileParams = (Map<String, Object>) SerializationUtils.deserialize(message.getBody());
            byte[] content = statementGenerator.pdfAcademicLeaveGenerating(fileParams);
            return new Message(content);
        } catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }

}
