package com.erplogic.api.controllers;

import com.erplogic.api.dto.StakeholderIndividualRequest;
import com.erplogic.api.dto.StakeholderIndividualResponse;
import com.erplogic.api.service.StakeholderIndividualService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stakeholder-individuals")
@RequiredArgsConstructor
public class StakeholderIndividualController {

    private final StakeholderIndividualService service;

    @PostMapping("/create-individual")
    public StakeholderIndividualResponse create(
          @RequestBody StakeholderIndividualRequest request) {

        return service.create(request);
    }

    @GetMapping("/getAllUsers")
    public List<StakeholderIndividualResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public StakeholderIndividualResponse getById(
            @PathVariable String id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public StakeholderIndividualResponse update(
            @PathVariable String id,
             @RequestBody StakeholderIndividualRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {

        service.delete(id);
    }
}
