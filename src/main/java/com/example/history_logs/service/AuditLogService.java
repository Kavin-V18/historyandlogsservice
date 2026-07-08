package com.example.history_logs.service;

import com.example.history_logs.dto.AuditLogDto;

import java.util.List;

public interface AuditLogService {

    AuditLogDto createAuditLogDto(AuditLogDto auditLogDto);
    AuditLogDto getAuditLogDtoById(int id);
    List<AuditLogDto> getAllAuditLogDto();
    AuditLogDto updateAuditLogDto(int id, AuditLogDto auditLogDto);
    String deleteAuditLogDto(int id);
}
