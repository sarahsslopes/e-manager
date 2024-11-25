package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.budget.BudgetDto;
import com.sa.development.eManager.domain.__shared.MapperBase;
import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import org.mapstruct.factory.Mappers;

public interface BudgetMapper extends MapperBase<BudgetEntity, BudgetDto> {

    BudgetMapper INSTANCE = Mappers.getMapper(BudgetMapper.class);
}
