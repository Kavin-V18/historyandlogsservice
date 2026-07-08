package com.example.history_logs.entity;


import com.example.history_logs.Action;
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
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class AuditLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name="table_name")
    private String tableName;
  @Column(name="record_id")
    private Integer recordId;
    @Enumerated(EnumType.STRING)
    private Action action;
  @Column(name="changed_data")
    private String changedData;
    //foreign-key--user
    @Column(name="performed_by")
    private Long performedBy;
  @Column(name="ip_address")
    private String ipAddress;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDateTime lastModifiedAt;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
}
