package com.example.HistoryAndLogsModule.Entity;

import com.example.APIgateway.entity.User;
import com.example.HistoryAndLogsModule.Action;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

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
    private String changed_data;
    //foreign-key
    private User performed_by;
    private String ip_address;
    @CreationTimestamp
    private LocalDateTime created_at;
    private String created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
