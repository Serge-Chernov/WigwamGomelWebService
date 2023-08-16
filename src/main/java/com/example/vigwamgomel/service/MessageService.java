package com.example.vigwamgomel.service;


import com.example.vigwamgomel.entity.Message;
import com.example.vigwamgomel.repository.MessageRepository;
import com.example.vigwamgomel.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    OrderRepository orderRepository;

    private static final String DEFAULT_MESSAGE = "Ваш заказ обрабатывается. Для уточнения деталей с вами свяжутся по " +
            "номеру указанному вами.";
    private static final String ORDER_CANCELED_MESSAGE = "Ваш заказ отменен.";
    private static final String ORDER_IN_PROGRESS_MESSAGE = "Ваш заказ изготавливается. Ожидайте оповещение по указанным" +
            " вами электронной почте, номеру телефона и в личном кабинете нашего сервиса";
    private static final String ORDER_COMPLETE_MESSAGE = "Ваш заказ готов к выдаче. Мы свяжемся с вами для уточнения" +
            "деталей доставки";

    public void sendDefaultMessage(Long recipientId) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu HH:mm"));
        Message message = new Message();
        message.setNotRead(true);
        message.setRecipientId(recipientId);
        message.setMessageText(DEFAULT_MESSAGE);
        message.setDate(date);
        messageRepository.save(message);

    }

    public void sendOrderCanceledMessage(Long recipientId) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu HH:mm"));
        Message message = new Message();
        message.setNotRead(true);
        message.setRecipientId(recipientId);
        message.setMessageText(ORDER_CANCELED_MESSAGE);
        message.setDate(date);
        messageRepository.save(message);

    }

    public void sendOrderInProgressMessage(Long recipientId) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu HH:mm"));
        Message message = new Message();
        message.setNotRead(true);
        message.setRecipientId(recipientId);
        message.setMessageText(ORDER_IN_PROGRESS_MESSAGE);
        message.setDate(date);
        messageRepository.save(message);

    }

    public void sendOrderCompleteMessage(Long recipientId) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu HH:mm"));
        Message message = new Message();
        message.setNotRead(true);
        message.setRecipientId(recipientId);
        message.setMessageText(ORDER_COMPLETE_MESSAGE);
        message.setDate(date);
        messageRepository.save(message);
    }

    public List<Message> findByRecipientId(long recipientId) {
        return messageRepository.findByRecipientId(recipientId);
    }

    public Optional<Message> findById(Long messageId) {
        return messageRepository.findById(messageId);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
