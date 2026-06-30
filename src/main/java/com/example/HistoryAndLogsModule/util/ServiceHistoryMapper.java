package com.example.HistoryAndLogsModule.util;

import com.example.HistoryAndLogsModule.Entity.ServiceHistory;
import com.example.HistoryAndLogsModule.dto.ServiceHistoryDto;
import org.springframework.stereotype.Component;

@Component
public class ServiceHistoryMapper {
    public ServiceHistoryDto toDto(ServiceHistory serviceHistory) {
        if (serviceHistory == null) return null;

        return ServiceHistoryDto.builder().service_center(serviceHistory.getService_center()).
                service_date(serviceHistory.getService_date()).
                service_type(serviceHistory.getService_type()).
                remarks(serviceHistory.getRemarks()).
                last_modified_at(serviceHistory.getLast_modified_at()).
                last_modified_by(serviceHistory.getLast_modified_by()).
                created_at(serviceHistory.getCreated_at()).
                created_by(serviceHistory.getCreated_by()).
                cost(serviceHistory.getCost()).build();
    }
    public ServiceHistory toEntity(ServiceHistoryDto dto) {
        if (dto == null) return null;
        ServiceHistory serviceHistory = new ServiceHistory();
        serviceHistory.setCost(dto.getCost());
        serviceHistory.setService_center(dto.getService_center());
        serviceHistory.setService_date(dto.getService_date());
        serviceHistory.setRemarks(dto.getRemarks());
        serviceHistory.setService_type(dto.getService_type());
        serviceHistory.setVehicle(dto.getVehicle());
        return serviceHistory;
    }
}
