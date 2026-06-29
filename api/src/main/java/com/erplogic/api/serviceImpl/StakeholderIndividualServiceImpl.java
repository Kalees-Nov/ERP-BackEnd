package com.erplogic.api.serviceImpl;

import com.erplogic.api.config.StakeholderIndividualMapper;
import com.erplogic.api.dto.StakeholderIndividualRequest;
import com.erplogic.api.dto.StakeholderIndividualResponse;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.entity.StakeholderIndividual;
import com.erplogic.api.repository.StakeholderIndividualRepository;
import com.erplogic.api.repository.StakeholderRepository;
import com.erplogic.api.service.StakeholderIndividualService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeholderIndividualServiceImpl
        implements StakeholderIndividualService {

    public StakeholderIndividualServiceImpl(StakeholderIndividualRepository individualRepository, StakeholderRepository stakeholderRepository, StakeholderIndividualMapper mapper) {
        this.individualRepository = individualRepository;
        this.stakeholderRepository = stakeholderRepository;
        this.mapper = mapper;
    }

    private final StakeholderIndividualRepository individualRepository;

    private final StakeholderRepository stakeholderRepository;

    private final StakeholderIndividualMapper mapper;

    @Override
    public StakeholderIndividualResponse create(
            StakeholderIndividualRequest request) {

        StakeholderMaster stakeholder = stakeholderRepository
                .findById(request.getStakeholderId())
                .orElseThrow(() ->
                        new RuntimeException("Stakeholder not found"));

        StakeholderIndividual individual =
                mapper.toEntity(request, stakeholder);

        StakeholderIndividual saved =
                individualRepository.save(individual);

        return mapper.toResponse(saved);
    }

    @Override
    public List<StakeholderIndividualResponse> getAll() {

        return individualRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StakeholderIndividualResponse getById(String id) {

        StakeholderIndividual individual =
                individualRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Individual not found"));

        return mapper.toResponse(individual);
    }

    @Override
    public StakeholderIndividualResponse update(
            String id,
            StakeholderIndividualRequest request) {

        StakeholderIndividual individual =
                individualRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Individual not found"));

        StakeholderMaster stakeholder =
                stakeholderRepository.findById(request.getStakeholderId())
                        .orElseThrow(() ->
                                new RuntimeException("Stakeholder not found"));

        individual.setStakeholder(stakeholder);
        individual.setSalutation(request.getSalutation());
        individual.setIndividualName(request.getIndividualName());
        individual.setResponsibility(request.getResponsibility());
        individual.setEmail(request.getEmail());
        individual.setPhoneCode(request.getPhoneCode());
        individual.setPhoneNumber(request.getPhoneNumber());
        individual.setMobileCode(request.getMobileCode());
        individual.setMobileNumber(request.getMobileNumber());
        individual.setActive(request.getActive());
        individual.setNotes(request.getNotes());

        StakeholderIndividual updated =
                individualRepository.save(individual);

        return mapper.toResponse(updated);
    }

    @Override
    public void delete(String id) {

        StakeholderIndividual individual =
                individualRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Individual not found"));

        individualRepository.delete(individual);
    }
}