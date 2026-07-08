package com.example.history_logs.service;

import com.example.history_logs.entity.AuditLog;
import com.example.history_logs.repository.AuditLogRepository;
import com.example.history_logs.dto.AuditLogDto;
import com.example.history_logs.util.AuditLogMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuditLogServiceImp  implements AuditLogService {
    private final AuditLogRepository auditLogRepository;
    private final AuditLogMapper auditLogMapper;
    @Override
    public AuditLogDto createAuditLogDto(AuditLogDto auditLogDto) {
        AuditLog entity = auditLogMapper.toEntity(auditLogDto);
        AuditLog savedEntity = auditLogRepository.save(entity);
        return auditLogMapper.toDto(savedEntity);
    }
    @Override
    public AuditLogDto getAuditLogDtoById(int id) {
        AuditLog existing=auditLogRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return auditLogMapper.toDto(existing);
    }
    @Override
    public List<AuditLogDto> getAllAuditLogDto() {
        return auditLogRepository.findAll().stream().map(auditLogMapper::toDto).toList();
    }
    @Override
    public AuditLogDto updateAuditLogDto(int id, AuditLogDto auditLogDto) {
        AuditLog existing=auditLogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setTableName(auditLogDto.getTableName());
        existing.setAction(auditLogDto.getAction());
        existing.setRecordId(auditLogDto.getRecordId());
        existing.setChangedData(auditLogDto.getChangedData());
        existing.setPerformedBy(auditLogDto.getPerformedBy());
        existing.setIpAddress(auditLogDto.getIpAddress());
        AuditLog savedEntity = auditLogRepository.save(existing);
        return auditLogMapper.toDto(savedEntity);
    }
    @Override
    public String deleteAuditLogDto(int id) {
        auditLogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        auditLogRepository.deleteById(id);
        return "deleted successfully";
    }
}
