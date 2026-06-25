package com.example.HistoryAndLogsModule.controller;


import com.example.HistoryAndLogsModule.dto.ServiceHistoryDto;
import com.example.HistoryAndLogsModule.service.ServiceHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicehistory")
@RequiredArgsConstructor
public class ServiceHistoryController {
     private final ServiceHistoryService serviceHistoryService;

    @GetMapping()
    public List<ServiceHistoryDto> getServiceHistory() {
        return serviceHistoryService.getAllServiceHistoryDto();
    }
    @PostMapping()
    public  String createServiceHistory(@Valid @RequestBody ServiceHistoryDto serviceHistoryDto){
        serviceHistoryService.createServiceHistoryDto(serviceHistoryDto);
        return  "Supplier Created Successfully";
    }
    @GetMapping("/{id}")
    public ServiceHistoryDto getServiceHistoryById(@PathVariable int id){
        return serviceHistoryService.getServiceHistoryDtoById(id);
    }
    @PostMapping("/{id}")
    public ServiceHistoryDto updateServiceHistory(@PathVariable int id,@Valid @RequestBody ServiceHistoryDto serviceHistoryDto){
        return  serviceHistoryService.updateServiceHistoryDto(id, serviceHistoryDto);
    }
    @DeleteMapping("/{id}")
    public String deleteServiceHistory(@PathVariable int id){
        serviceHistoryService.deleteServiceHistoryDto(id);
        return "supplier Deleted Successfully";
    }
}
