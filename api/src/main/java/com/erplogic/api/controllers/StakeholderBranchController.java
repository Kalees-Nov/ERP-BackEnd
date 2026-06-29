package com.erplogic.api.controllers;

import com.erplogic.api.dto.StakeholderBranchRequest;
import com.erplogic.api.dto.StakeholderBranchResponse;
import com.erplogic.api.service.StakeholderBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stakeholder-branches")
@RequiredArgsConstructor
public class StakeholderBranchController {

    private final StakeholderBranchService service;

    @PostMapping("/create-branches")
    public StakeholderBranchResponse create(
            @RequestBody StakeholderBranchRequest request) {

        return service.create(request);
    }

    @GetMapping("/getAllBranches")
    public List<StakeholderBranchResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public StakeholderBranchResponse getById(@PathVariable String id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public StakeholderBranchResponse update(
            @PathVariable String id,
            @RequestBody StakeholderBranchRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {

        service.delete(id);
    }
}