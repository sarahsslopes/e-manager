package com.sa.development.eManager.domain.service;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends RepositoryBase<ServiceEntity, String> {}
