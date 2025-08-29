package com.portfolio.portfolio.service;

import com.portfolio.portfolio.dto.ContactMessageRequest;
import com.portfolio.portfolio.entity.ContactMessage;
import com.portfolio.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public ContactMessage save(ContactMessageRequest req) {
        ContactMessage m = new ContactMessage();
        m.setName(req.getName());
        m.setEmail(req.getEmail());
        m.setContent(req.getContent());
        return repository.save(m);
    }


    public List<ContactMessage> getAllMessages() {
        return repository.findAll();
    }


    public ContactMessage getMessageById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }

    public ContactMessage updateMessage(Long id, ContactMessageRequest req) {
        ContactMessage message = repository.findById(id).orElse(null);
        if (message != null) {
            message.setName(req.getName());
            message.setEmail(req.getEmail());
            message.setContent(req.getContent());
            return repository.save(message);
        }
        return null;
    }
}
