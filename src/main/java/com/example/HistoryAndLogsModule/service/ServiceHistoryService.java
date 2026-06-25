package com.example.HistoryAndLogsModule.service;

import com.example.HistoryAndLogsModule.dto.ServiceHistoryDto;
import java.util.List;
public interface ServiceHistoryService {

    ServiceHistoryDto createServiceHistoryDto(ServiceHistoryDto serviceHistoryDto);
    ServiceHistoryDto getServiceHistoryDtoById(int id);
    List<ServiceHistoryDto> getAllServiceHistoryDto();
    ServiceHistoryDto updateServiceHistoryDto(int id, ServiceHistoryDto serviceHistoryDto);
    String deleteServiceHistoryDto(int id);
}

