package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {
}
