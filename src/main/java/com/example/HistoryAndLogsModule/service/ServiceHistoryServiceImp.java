package com.example.HistoryAndLogsModule.service;

import com.example.HistoryAndLogsModule.Entity.ServiceHistory;
import com.example.HistoryAndLogsModule.Repository.ServiceHistoryRepository;
import com.example.HistoryAndLogsModule.dto.ServiceHistoryDto;
import com.example.HistoryAndLogsModule.util.ServiceHistoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceHistoryServiceImp implements ServiceHistoryService{
          private final ServiceHistoryRepository serviceHistoryRepository;
          private final ServiceHistoryMapper serviceHistoryMapper;
    @Override
    public ServiceHistoryDto createServiceHistoryDto(ServiceHistoryDto serviceHistoryDto) {
        ServiceHistory entity = serviceHistoryMapper.toEntity(serviceHistoryDto); // DTO -> Entity
        ServiceHistory savedEntity = serviceHistoryRepository.save(entity);
        return serviceHistoryMapper.toDto(savedEntity);
    }
    @Override
    public ServiceHistoryDto getServiceHistoryDtoById(int id) {
        ServiceHistory existing=serviceHistoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        ServiceHistoryDto serviceHistoryDto= serviceHistoryMapper.toDto(existing);
        return  serviceHistoryDto;
    }
    @Override
    public List<ServiceHistoryDto> getAllServiceHistoryDto() {
        return serviceHistoryRepository.findAll().stream().map(serviceHistoryMapper::toDto).toList();
    }
    @Override
    public ServiceHistoryDto updateServiceHistoryDto(int id, ServiceHistoryDto serviceHistoryDto) {
        ServiceHistory existing=serviceHistoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        existing.setService_center(serviceHistoryDto.getService_center());
        existing.setRemarks(serviceHistoryDto.getRemarks());
        existing.setService_type(serviceHistoryDto.getService_type());
        existing.setCost(serviceHistoryDto.getCost());
        existing.setCreated_by(serviceHistoryDto.getCreated_by());
        existing.setLast_modified_by(serviceHistoryDto.getLast_modified_by());
        existing.setService_date(serviceHistoryDto.getService_date());
        ServiceHistory updatedEntity=serviceHistoryRepository.save(existing);
        return  serviceHistoryMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteServiceHistoryDto(int id) {
        ServiceHistory existing=serviceHistoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        serviceHistoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
