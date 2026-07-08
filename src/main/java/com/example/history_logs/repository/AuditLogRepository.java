package com.example.history_logs.repository;

import com.example.history_logs.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog,Integer> {
}
