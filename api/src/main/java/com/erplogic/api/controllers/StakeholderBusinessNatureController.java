package com.erplogic.api.controllers;

import com.erplogic.api.dto.StakeholderBusinessNatureRequest;
import com.erplogic.api.dto.StakeholderBusinessNatureResponse;
import com.erplogic.api.service.StakeholderBusinessNatureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stakeholder-business-natures")
@RequiredArgsConstructor
public class StakeholderBusinessNatureController {

    private final StakeholderBusinessNatureService service;

    @PostMapping("/create-business-nature")
    public StakeholderBusinessNatureResponse create(
            @RequestBody StakeholderBusinessNatureRequest request) {

        return service.create(request);
    }

    @GetMapping("/get-All-business-nature")
    public List<StakeholderBusinessNatureResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public StakeholderBusinessNatureResponse getById(
            @PathVariable String id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public StakeholderBusinessNatureResponse update(
            @PathVariable String id,
            @Valid @RequestBody StakeholderBusinessNatureRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {

        service.delete(id);
    }
}