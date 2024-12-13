package com.sa.development.eManager.domain.person;

import com.sa.development.eManager.domain.person.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {}
