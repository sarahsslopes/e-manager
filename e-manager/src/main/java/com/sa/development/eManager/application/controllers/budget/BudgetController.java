package com.sa.development.eManager.application.controllers.budget;

import com.sa.development.eManager.application.dtos.budget.BudgetDto;
import com.sa.development.eManager.application.services.budget.BudgetService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/budget")
public class BudgetController {

    @Resource
    private BudgetService budgetService;

    @GetMapping(value = "/{id}")
    public BudgetDto getBudget(@PathVariable String id) {
        return budgetService.findById(id);
    }

    @GetMapping()
    public List<BudgetDto> listBudgets() {
        return budgetService.findAll();
    }

    @PostMapping()
    public void createBudget(@RequestBody BudgetDto budgetDto) {
        budgetService.save(budgetDto);
    }
}
