package com.example.history_logs.service;

import com.example.history_logs.client.QualityInventoryClient;
import com.example.history_logs.entity.ServiceHistory;
import com.example.history_logs.repository.ServiceHistoryRepository;
import com.example.history_logs.dto.ServiceHistoryDto;
import com.example.history_logs.util.ServiceHistoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceHistoryServiceImp implements ServiceHistoryService{
          private final ServiceHistoryRepository serviceHistoryRepository;
          private final ServiceHistoryMapper serviceHistoryMapper;
          private final QualityInventoryClient qualityInventoryClient;
    @Override
    public ServiceHistoryDto createServiceHistoryDto(ServiceHistoryDto serviceHistoryDto) {
        Boolean inventoryExist=qualityInventoryClient.checkInventoryExists(serviceHistoryDto.getVehicle()).getBody();
        if (Boolean.FALSE.equals(inventoryExist)) {
            throw new EntityNotFoundException("Inventory not found with id : " + serviceHistoryDto.getVehicle());
        }
        ServiceHistory entity = serviceHistoryMapper.toEntity(serviceHistoryDto);
        ServiceHistory savedEntity = serviceHistoryRepository.save(entity);
        return serviceHistoryMapper.toDto(savedEntity);
    }
    @Override
    public ServiceHistoryDto getServiceHistoryDtoById(int id) {
        ServiceHistory existing=serviceHistoryRepository.findById(id).orElseThrow( EntityNotFoundException::new);
        return serviceHistoryMapper.toDto(existing);
    }
    @Override
    public List<ServiceHistoryDto> getAllServiceHistoryDto() {
        return serviceHistoryRepository.findAll().stream().map(serviceHistoryMapper::toDto).toList();
    }
    @Override
    public ServiceHistoryDto updateServiceHistoryDto(int id, ServiceHistoryDto serviceHistoryDto) {
        ServiceHistory existing=serviceHistoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        Boolean inventoryExist=qualityInventoryClient.checkInventoryExists(serviceHistoryDto.getVehicle()).getBody();
        if (Boolean.FALSE.equals(inventoryExist)) {
            throw new EntityNotFoundException("Inventory not found with id : " + serviceHistoryDto.getVehicle());
        }
        existing.setServiceCenter(serviceHistoryDto.getServiceCenter());
        existing.setRemarks(serviceHistoryDto.getRemarks());
        existing.setServiceType(serviceHistoryDto.getServiceType());
        existing.setCost(serviceHistoryDto.getCost());
        existing.setCreatedBy(serviceHistoryDto.getCreatedBy());
        existing.setLastModifiedBy(serviceHistoryDto.getLastModifiedBy());
        existing.setServiceDate(serviceHistoryDto.getServiceDate());
        ServiceHistory updatedEntity=serviceHistoryRepository.save(existing);
        return  serviceHistoryMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteServiceHistoryDto(int id) {
        serviceHistoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        serviceHistoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
