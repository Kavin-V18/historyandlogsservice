package com.example.HistoryAndLogsModule.Entity;


import com.example.HistoryAndLogsModule.Action;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name="auditlog",schema = "public")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class AuditLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
    private String table_name;
    private int record_id;
    @Enumerated(EnumType.STRING)
    private Action action;
    private String changed_data;
    //foreign-key--user
    private Long performed_by;
    private String ip_address;
    @CreationTimestamp
    private LocalDateTime created_at;
    @CreatedBy
    private Long created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @LastModifiedBy
    private Long last_modified_by;
  @Column(name = "deleted", nullable = false)
  private boolean deleted;
}
