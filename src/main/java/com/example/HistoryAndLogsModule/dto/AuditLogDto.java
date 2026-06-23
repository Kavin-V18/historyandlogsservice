package com.example.HistoryAndLogsModule.dto;

import com.example.HistoryAndLogsModule.Action;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AuditLogDto {
    private String table_name;
    private int record_id;
    private Action action;
    private String ip_address;
    private LocalDate created_at;
}
