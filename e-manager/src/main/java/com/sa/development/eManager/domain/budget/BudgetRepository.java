package com.sa.development.eManager.domain.budget;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends RepositoryBase<BudgetEntity, String> {}
