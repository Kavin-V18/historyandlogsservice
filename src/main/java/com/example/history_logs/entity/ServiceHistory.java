package com.example.history_logs.entity;

import com.example.history_logs.ServiceType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="servicehistory",schema = "public")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class ServiceHistory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
 //foreign key vehicle inventory
    private Long vehicle;
    @Column(nullable = false,name="service_date")
    private LocalDate serviceDate;
    @Column(nullable = false,name="service_center")
    private String serviceCenter;
    @Column(name="service_type")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    @Column(nullable = false)
    private Double cost;
     private String remarks;
    @Column(name="created_at")
     private LocalDate createdAt;
     @CreatedBy
     @Column(name="created_by")
     private Long createdBy;
    @Column(name="last_modified_at")
     private LocalDateTime lastModifiedAt;
     @LastModifiedBy
     @Column(name="last_modified_by")
     private Long lastModifiedBy;
}
