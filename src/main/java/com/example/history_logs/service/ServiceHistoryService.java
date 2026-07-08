package com.example.history_logs.service;

import com.example.history_logs.dto.ServiceHistoryDto;
import java.util.List;
public interface ServiceHistoryService {

    ServiceHistoryDto createServiceHistoryDto(ServiceHistoryDto serviceHistoryDto);
    ServiceHistoryDto getServiceHistoryDtoById(int id);
    List<ServiceHistoryDto> getAllServiceHistoryDto();
    ServiceHistoryDto updateServiceHistoryDto(int id, ServiceHistoryDto serviceHistoryDto);
    String deleteServiceHistoryDto(int id);
}

