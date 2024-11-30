package com.sa.development.eManager.application.services.budget;

import com.sa.development.eManager.__shared.ServiceBase;
import com.sa.development.eManager.__shared.exceptions.NotFoundException;
import com.sa.development.eManager.application.dtos.budget.BudgetDto;
import com.sa.development.eManager.domain.budget.BudgetRepository;
import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import com.sa.development.eManager.infraestructure.mappers.BudgetMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService implements ServiceBase<BudgetDto, String> {

    @Resource
    private BudgetRepository budgetRepository;

    private final BudgetMapper budgetMapper = BudgetMapper.INSTANCE;

    @Override
    public BudgetDto findById(String id) {
        return budgetRepository.findById(id)
                .map(budgetMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    @Override
    public void save(BudgetDto dto) {
        budgetRepository.save(budgetMapper.toEntity(dto));
    }

    @Override
    public List<BudgetDto> findAll() {
        List<BudgetEntity> budgets = budgetRepository.findAll();

        if (budgets.isEmpty()) {
            throw new NotFoundException("No budgets found");
        }

        return budgetMapper.toDtoList(budgets);
    }

    @Override
    public void delete(String id) {
        if (!budgetRepository.existsById(id)) {
            throw new NotFoundException("Budget not found");
        }

        budgetRepository.deleteById(id);
    }
}
