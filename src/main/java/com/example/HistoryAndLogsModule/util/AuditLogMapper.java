package com.example.HistoryAndLogsModule.util;

import com.example.HistoryAndLogsModule.Entity.AuditLog;
import com.example.HistoryAndLogsModule.dto.AuditLogDto;
import org.springframework.stereotype.Component;

@Component
public class AuditLogMapper {

    public AuditLogDto toDto(AuditLog auditLog) {
        if (auditLog == null) return null;

        return AuditLogDto.builder().table_name(auditLog.getTable_name()).
                record_id(auditLog.getRecord_id()).
                action(auditLog.getAction()).
                performed_by(auditLog.getPerformed_by()).
                ip_address(auditLog.getIp_address()).
                created_at(auditLog.getCreated_at()).
                created_by(auditLog.getCreated_by()).
                last_modified_at(auditLog.getLast_modified_at()).
                last_modified_by(auditLog.getLast_modified_by()).
                build();
    }
    public AuditLog toEntity(AuditLogDto dto) {
        if (dto == null) return null;
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(dto.getAction());
        auditLog.setChanged_data(dto.getChanged_data());
        auditLog.setPerformed_by(dto.getPerformed_by());
        auditLog.setIp_address(dto.getIp_address());
        auditLog.setTable_name(dto.getTable_name());
        auditLog.setRecord_id(dto.getRecord_id());
        return auditLog;
    }
}
