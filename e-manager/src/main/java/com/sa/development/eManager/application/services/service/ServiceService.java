package com.sa.development.eManager.application.services.service;

import com.sa.development.eManager.__shared.ServiceBase;
import com.sa.development.eManager.__shared.exceptions.NotFoundException;
import com.sa.development.eManager.application.dtos.service.ServiceDto;
import com.sa.development.eManager.domain.service.ServiceRepository;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;
import com.sa.development.eManager.infraestructure.mappers.ServiceMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements ServiceBase<ServiceDto, String> {

    @Resource
    private ServiceRepository serviceRepository;

    private final ServiceMapper serviceMapper = ServiceMapper.INSTANCE;

    @Override
    public ServiceDto findById(String id) {
        return serviceRepository.findById(id)
                .map(serviceMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Service not found"));
    }

    @Override
    public void save(ServiceDto dto) {
        serviceRepository.save(serviceMapper.toEntity(dto));
    }

    @Override
    public List<ServiceDto> findAll() {
        List<ServiceEntity> services = serviceRepository.findAll();

        if (services.isEmpty()) {
            throw new NotFoundException("No services found");
        }

        return serviceMapper.toDtoList(services);
    }

    @Override
    public void delete(String id) {
        if (!serviceRepository.existsById(id)) {
            throw new NotFoundException("Service not found");
        }

        serviceRepository.deleteById(id);
    }
}
