package com.example.HistoryAndLogsModule.Entity;

import com.example.HistoryAndLogsModule.ServiceType;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Table(name="servicehistory",schema = "public")
@Entity
@Data
public class ServiceHistory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
 //foreign key
    private VehicleInventory vehicle;
    @NotNull
    @Column(nullable = false)
    private LocalDate service_date;
    @NotNull
    @Column(nullable = false)
    private String service_center;
    @Enumerated(EnumType.STRING)
    private ServiceType service_type;
    @NotNull
    @Column(nullable = false)
    @Min((1))
    private double cost;
     private String remarks;
}
