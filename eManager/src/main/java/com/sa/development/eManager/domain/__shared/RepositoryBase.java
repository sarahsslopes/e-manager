package com.sa.development.eManager.domain.__shared;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBase<T, ID> extends JpaRepository<T, ID> {}
