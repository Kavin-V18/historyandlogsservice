package com.example.history_logs.controller;


import com.example.history_logs.dto.ServiceHistoryDto;
import com.example.history_logs.service.ServiceHistoryService;
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
    @PutMapping("/{id}")
    public ServiceHistoryDto updateServiceHistory(@PathVariable int id,@Valid @RequestBody ServiceHistoryDto serviceHistoryDto){
        return  serviceHistoryService.updateServiceHistoryDto(id, serviceHistoryDto);
    }
    @DeleteMapping("/{id}")
    public String deleteServiceHistory(@PathVariable int id){
        serviceHistoryService.deleteServiceHistoryDto(id);
        return "supplier Deleted Successfully";
    }
}
