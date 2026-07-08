package com.example.history_logs.util;

import com.example.history_logs.entity.AuditLog;
import com.example.history_logs.dto.AuditLogDto;
import org.springframework.stereotype.Component;

@Component
public class AuditLogMapper {

    public AuditLogDto toDto(AuditLog auditLog) {
        if (auditLog == null) return null;

        return AuditLogDto.builder().tableName(auditLog.getTableName()).
                recordId(auditLog.getRecordId()).
                action(auditLog.getAction()).
                performedBy(auditLog.getPerformedBy()).
                ipAddress(auditLog.getIpAddress()).
                createdAt(auditLog.getCreatedAt()).
                createdBy(auditLog.getCreatedBy()).
                lastModifiedAt(auditLog.getLastModifiedAt()).
                lastModifiedBy(auditLog.getLastModifiedBy()).
                build();
    }
    public AuditLog toEntity(AuditLogDto dto) {
        if (dto == null) return null;
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(dto.getAction());
        auditLog.setChangedData(dto.getChangedData());
        auditLog.setPerformedBy(dto.getPerformedBy());
        auditLog.setIpAddress(dto.getIpAddress());
        auditLog.setTableName(dto.getTableName());
        auditLog.setRecordId(dto.getRecordId());
        return auditLog;
    }
}
