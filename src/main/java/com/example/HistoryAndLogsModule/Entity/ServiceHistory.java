package com.example.HistoryAndLogsModule.Entity;

import com.example.HistoryAndLogsModule.ServiceType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="servicehistory",schema = "public")
@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class ServiceHistory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
 //foreign key--vehicle inventory
    private long vehicle;
    @Column(nullable = false)
    private LocalDate service_date;
    @Column(nullable = false)
    private String service_center;
    @Enumerated(EnumType.STRING)
    private ServiceType service_type;
    @Column(nullable = false)
    private double cost;
     private String remarks;
     private LocalDate created_at;
     @CreatedBy
     private Long created_by;
     private LocalDateTime last_modified_at;
     @LastModifiedBy
     private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
