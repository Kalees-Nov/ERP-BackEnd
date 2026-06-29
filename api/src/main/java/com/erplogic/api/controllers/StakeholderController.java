package com.erplogic.api.controllers;

import com.erplogic.api.dto.StakeholderRequest;
import com.erplogic.api.dto.StakeholderResponse;
import com.erplogic.api.service.StakeholderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stakeholders")
@RequiredArgsConstructor
public class StakeholderController {
    @Autowired
    private final StakeholderService service;

    @PostMapping("/create")
    public StakeholderResponse createStakeholder(
            @RequestBody StakeholderRequest request) {

        return service.createStakeholder(request);
    }

    @GetMapping("/{id}")
    public StakeholderResponse getStakeholderById(@PathVariable String id) {

        return service.getStakeholderById(id);
    }

    @GetMapping("/getAllUsers")
    public List<StakeholderResponse> getAllStakeholders() {

        return service.getAllStakeholders();
    }

    @PutMapping("/{id}")
    public StakeholderResponse updateStakeholder(
            @PathVariable String id,
            @RequestBody StakeholderRequest request) {

        return service.updateStakeholder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteStakeholder(@PathVariable String id) {

        service.deleteStakeholder(id);
    }

}
