package com.example.history_logs.controller;

import com.example.history_logs.dto.AuditLogDto;
import com.example.history_logs.service.AuditLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auditlog")
@RequiredArgsConstructor
public class AuditLogController {
    private final AuditLogService auditLogService;

    @GetMapping()
    public List<AuditLogDto> getAuditLog() {
        return auditLogService.getAllAuditLogDto();
    }
    @PostMapping()
    public  String createAuditLog(@Valid @RequestBody AuditLogDto auditLogDto){
        auditLogService.createAuditLogDto(auditLogDto);
        return  "Auditlog Created Successfully";
    }
    @GetMapping("/{id}")
    public AuditLogDto getAuditLogById(@PathVariable int id){
        return auditLogService.getAuditLogDtoById(id);
    }
    @PutMapping("/{id}")
    public AuditLogDto updateAuditLog(@PathVariable int id,@Valid @RequestBody AuditLogDto auditLogDto){
        return  auditLogService.updateAuditLogDto(id, auditLogDto);
    }
    @DeleteMapping("/{id}")
    public String deleteAuditLog(@PathVariable int id){
        auditLogService.deleteAuditLogDto(id);
        return "Auditlog Deleted Successfully";
    }
}
