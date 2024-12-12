package com.sa.development.eManager.domain.customer;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends RepositoryBase<CustomerEntity, String> {}
