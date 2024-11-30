package com.sa.development.eManager.application.services.service;

import com.sa.development.eManager.application.dtos.service.ServiceDto;
import com.sa.development.eManager.__shared.ServiceBase;
import com.sa.development.eManager.__shared.exceptions.NotFoundException;
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
        ServiceEntity service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            throw new NotFoundException("Service not found");
        }

        return serviceMapper.toDto(service);
    }

    @Override
    public void save(ServiceDto dto) {
        ServiceEntity service = serviceMapper.toEntity(dto);

        if (service != null) {
            serviceRepository.save(service);
        }
    }

    @Override
    public List<ServiceDto> findAll() {
        List<ServiceEntity> services = serviceRepository.findAll();

        if (services.isEmpty()) {
            throw new NotFoundException("Services not found");
        }

        return serviceMapper.toDtoList(services);
    }

    @Override
    public void delete(String id) {
        serviceRepository.findById(id).ifPresent(service -> serviceRepository.delete(service));
    }
}
