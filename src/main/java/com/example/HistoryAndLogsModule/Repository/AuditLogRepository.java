package com.example.HistoryAndLogsModule.Repository;

import com.example.HistoryAndLogsModule.Entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog,Integer> {
}
