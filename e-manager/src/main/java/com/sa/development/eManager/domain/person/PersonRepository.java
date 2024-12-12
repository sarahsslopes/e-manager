package com.sa.development.eManager.domain.person;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.person.entities.PersonEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends RepositoryBase<PersonEntity, String> {}
