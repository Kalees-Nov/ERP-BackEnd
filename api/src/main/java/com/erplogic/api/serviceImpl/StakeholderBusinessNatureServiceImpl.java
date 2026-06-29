package com.erplogic.api.serviceImpl;

import com.erplogic.api.config.StakeholderBusinessNatureMapper;
import com.erplogic.api.dto.StakeholderBusinessNatureRequest;
import com.erplogic.api.dto.StakeholderBusinessNatureResponse;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.entity.StakeholderBusinessNature;
import com.erplogic.api.repository.StakeholderBusinessNatureRepository;
import com.erplogic.api.repository.StakeholderRepository;
import com.erplogic.api.service.StakeholderBusinessNatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StakeholderBusinessNatureServiceImpl
        implements StakeholderBusinessNatureService {

    public StakeholderBusinessNatureServiceImpl(StakeholderBusinessNatureRepository businessNatureRepository, StakeholderRepository stakeholderRepository, StakeholderBusinessNatureMapper mapper) {
        this.businessNatureRepository = businessNatureRepository;
        this.stakeholderRepository = stakeholderRepository;
        this.mapper = mapper;
    }

    private final StakeholderBusinessNatureRepository businessNatureRepository;
    private final StakeholderRepository stakeholderRepository;
    private final StakeholderBusinessNatureMapper mapper;

    @Override
    public StakeholderBusinessNatureResponse create(
            StakeholderBusinessNatureRequest request) {

        StakeholderMaster stakeholder = stakeholderRepository.findById(request.getStakeholderId())
                .orElseThrow(() ->
                        new RuntimeException("Stakeholder not found"));

        StakeholderBusinessNature businessNature =
                mapper.toEntity(request, stakeholder);

        StakeholderBusinessNature saved =
                businessNatureRepository.save(businessNature);

        return mapper.toResponse(saved);
    }

    @Override
    public List<StakeholderBusinessNatureResponse> getAll() {

        return businessNatureRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StakeholderBusinessNatureResponse getById(String id) {

        StakeholderBusinessNature businessNature =
                businessNatureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Business Nature not found"));

        return mapper.toResponse(businessNature);
    }

    @Override
    public StakeholderBusinessNatureResponse update(
            String id,
            StakeholderBusinessNatureRequest request) {

        StakeholderBusinessNature businessNature =
                businessNatureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Business Nature not found"));

        StakeholderMaster stakeholder =
                stakeholderRepository.findById(request.getStakeholderId())
                        .orElseThrow(() ->
                                new RuntimeException("Stakeholder not found"));

        businessNature.setStakeholder(stakeholder);
        businessNature.setBusinessNature(request.getBusinessNature());

        StakeholderBusinessNature updated =
                businessNatureRepository.save(businessNature);

        return mapper.toResponse(updated);
    }

    @Override
    public void delete(String id) {

        StakeholderBusinessNature businessNature =
                businessNatureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Business Nature not found"));

        businessNatureRepository.delete(businessNature);
    }
}