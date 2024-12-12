package com.sa.development.eManager.domain.employee;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends RepositoryBase<EmployeeEntity, String> {}
