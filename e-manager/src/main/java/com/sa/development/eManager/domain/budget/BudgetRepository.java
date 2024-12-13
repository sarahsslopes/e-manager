package com.sa.development.eManager.domain.budget;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, String> {}
