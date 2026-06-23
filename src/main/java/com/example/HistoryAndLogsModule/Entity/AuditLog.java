package com.example.HistoryAndLogsModule.Entity;

import com.example.HistoryAndLogsModule.Action;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name="auditlog",schema = "public")
@Entity
@Data
public class AuditLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
    private String table_name;

    private int record_id;
    @Enumerated(EnumType.STRING)
    private Action action;

    private String ip_address;

    private LocalDate created_at;
}
