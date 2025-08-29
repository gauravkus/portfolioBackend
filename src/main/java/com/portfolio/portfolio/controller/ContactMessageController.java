package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.ContactMessageRequest;
import com.portfolio.portfolio.entity.ContactMessage;
import com.portfolio.portfolio.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/contact-message")
@CrossOrigin(origins = "*")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;


    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    public ResponseEntity<ContactMessage> saveMessage(@RequestBody @Valid ContactMessageRequest request) {
        return ResponseEntity.ok(contactMessageService.save(request));
    }


    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        return ResponseEntity.ok(contactMessageService.getAllMessages());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessageById(@PathVariable Long id) {
        ContactMessage message = contactMessageService.getMessageById(id);
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactMessage> updateMessage(
            @PathVariable Long id,
            @RequestBody ContactMessageRequest req) {
        ContactMessage updated = contactMessageService.updateMessage(id, req);
        return ResponseEntity.ok(updated);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
