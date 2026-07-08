package com.example.history_logs.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInventoryDto {

    @NotBlank
    private String vin;
    //foreign key-producton order
    private Long productionOrders;
    //foreign key-carModel
    private Long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private String status;
    @NotBlank
    private LocalDate manufacturedDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String lastModifiedBy;
}
