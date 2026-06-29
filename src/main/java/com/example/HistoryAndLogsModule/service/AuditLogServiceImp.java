package com.example.HistoryAndLogsModule.service;

import com.example.HistoryAndLogsModule.Entity.AuditLog;
import com.example.HistoryAndLogsModule.Repository.AuditLogRepository;
import com.example.HistoryAndLogsModule.dto.AuditLogDto;
import com.example.HistoryAndLogsModule.util.AuditLogMapper;
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
        AuditLog entity = auditLogMapper.toEntity(auditLogDto); // DTO -> Entity
        AuditLog savedEntity = auditLogRepository.save(entity);
        return auditLogMapper.toDto(savedEntity);
    }
    @Override
    public AuditLogDto getAuditLogDtoById(int id) {
        AuditLog existing=auditLogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        AuditLogDto AuditLogDto= auditLogMapper.toDto(existing);
        return  AuditLogDto;
    }

    @Override
    public List<AuditLogDto> getAllAuditLogDto() {
        return auditLogRepository.findAll().stream().map(auditLogMapper::toDto).toList();
    }

    @Override
    public AuditLogDto updateAuditLogDto(int id, AuditLogDto auditLogDto) {
        AuditLog existing=auditLogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setTable_name(auditLogDto.getTable_name());
        existing.setAction(auditLogDto.getAction());
        existing.setRecord_id(auditLogDto.getRecord_id());
        existing.setChanged_data(auditLogDto.getChanged_data());
        existing.setPerformed_by(auditLogDto.getPerformed_by());
        existing.setIp_address(auditLogDto.getIp_address());
        AuditLog savedEntity = auditLogRepository.save(existing);
        return auditLogMapper.toDto(savedEntity);
    }
    @Override
    public String deleteAuditLogDto(int id) {
        AuditLog existing=auditLogRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        auditLogRepository.deleteById(id);
        return "deleted successfully";
    }
}
