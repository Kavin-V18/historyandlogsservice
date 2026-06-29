package com.example.HistoryAndLogsModule.service;

import com.example.HistoryAndLogsModule.dto.AuditLogDto;

import java.util.List;

public interface AuditLogService {

    AuditLogDto createAuditLogDto(AuditLogDto auditLogDto);
    AuditLogDto getAuditLogDtoById(int id);
    List<AuditLogDto> getAllAuditLogDto();
    AuditLogDto updateAuditLogDto(int id, AuditLogDto auditLogDto);
    String deleteAuditLogDto(int id);
}
