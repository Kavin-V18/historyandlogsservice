package com.example.HistoryAndLogsModule.dto;

import com.example.HistoryAndLogsModule.ServiceType;
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
    private LocalDate service_date;
    @NotBlank
    @Column(nullable = false)
    private String service_center;
    @Enumerated(EnumType.STRING)
    private ServiceType service_type;
    @NotBlank
    @Column(nullable = false)
    @Min((1))
    private double cost;
    private String remarks;
    private LocalDate created_at;
    private Long created_by;
    private LocalDateTime last_modified_at;
    private Long last_modified_by;
}
