package com.sa.development.eManager.application.controllers.service;

import com.sa.development.eManager.application.dtos.service.ServiceDto;
import com.sa.development.eManager.application.services.service.ServiceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private ServiceService serviceService;

    @GetMapping(value = "{/id}")
    public ServiceDto getService(@PathVariable String id) {
        return serviceService.findById(id);
    }

    @GetMapping()
    public List<ServiceDto> listServices() {
        return serviceService.findAll();
    }

    @PostMapping()
    public void createService(@RequestBody ServiceDto serviceDto) {
        serviceService.save(serviceDto);
    }
}
