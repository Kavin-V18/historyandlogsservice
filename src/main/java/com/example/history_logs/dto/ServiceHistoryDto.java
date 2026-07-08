package com.example.history_logs.dto;

import com.example.history_logs.ServiceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceHistoryDto {
    //foreign key--vehicle inventory
    private Long vehicle;
    @NotBlank
    @Column(nullable = false)
    private LocalDate serviceDate;
    @NotBlank
    @Column(nullable = false)
    private String serviceCenter;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    @Column(nullable = false)
    @Min((1))
    private Double cost;
    private String remarks;
    private LocalDate createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
