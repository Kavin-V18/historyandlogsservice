package com.example.history_logs.util;

import com.example.history_logs.entity.ServiceHistory;
import com.example.history_logs.dto.ServiceHistoryDto;
import org.springframework.stereotype.Component;
@Component
public class ServiceHistoryMapper {
    public ServiceHistoryDto toDto(ServiceHistory serviceHistory) {
        if (serviceHistory == null) return null;

        return ServiceHistoryDto.builder().serviceCenter(serviceHistory.getServiceCenter()).
                serviceDate(serviceHistory.getServiceDate()).
                serviceType(serviceHistory.getServiceType()).
                remarks(serviceHistory.getRemarks()).
                lastModifiedAt(serviceHistory.getLastModifiedAt()).
                lastModifiedBy(serviceHistory.getLastModifiedBy()).
                createdAt(serviceHistory.getCreatedAt()).
                createdBy(serviceHistory.getCreatedBy()).
                cost(serviceHistory.getCost()).build();
    }
    public ServiceHistory toEntity(ServiceHistoryDto dto) {
        if (dto == null) return null;
        ServiceHistory serviceHistory = new ServiceHistory();
        serviceHistory.setCost(dto.getCost());
        serviceHistory.setServiceCenter(dto.getServiceCenter());
        serviceHistory.setServiceDate(dto.getServiceDate());
        serviceHistory.setRemarks(dto.getRemarks());
        serviceHistory.setServiceType(dto.getServiceType());
        serviceHistory.setVehicle(dto.getVehicle());
        return serviceHistory;
    }
}
