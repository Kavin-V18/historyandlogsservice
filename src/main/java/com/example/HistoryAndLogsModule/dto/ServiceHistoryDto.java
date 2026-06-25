package com.example.HistoryAndLogsModule.dto;

import com.example.HistoryAndLogsModule.ServiceType;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ServiceHistoryDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //foreign key
    private VehicleInventory vehicle;
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
    private String created_by;
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
