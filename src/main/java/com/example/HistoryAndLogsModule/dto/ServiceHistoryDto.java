package com.example.HistoryAndLogsModule.dto;

import com.example.HistoryAndLogsModule.ServiceType;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ServiceHistoryDto {
    private VehicleInventory vehicle;
    private LocalDate service_date;
    private String service_center;
    private ServiceType service_type;
    private double cost;
    private String remarks;
}
