package com.erplogic.api.serviceImpl;

import com.erplogic.api.config.StakeholderBranchMapper;
import com.erplogic.api.dto.StakeholderBranchRequest;
import com.erplogic.api.dto.StakeholderBranchResponse;
import com.erplogic.api.entity.StakeholderBranch;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.repository.StakeholderBranchRepository;
import com.erplogic.api.repository.StakeholderRepository;
import com.erplogic.api.service.StakeholderBranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeholderBranchServiceImpl implements StakeholderBranchService {
    public StakeholderBranchServiceImpl(StakeholderBranchRepository branchRepository, StakeholderRepository stakeholderRepository, StakeholderBranchMapper mapper) {
        this.branchRepository = branchRepository;
        this.stakeholderRepository = stakeholderRepository;
        this.mapper = mapper;
    }

    private final StakeholderBranchRepository branchRepository;
    private final StakeholderRepository stakeholderRepository;
    private final StakeholderBranchMapper mapper;

    @Override
    public StakeholderBranchResponse create(StakeholderBranchRequest request) {

        StakeholderMaster stakeholder = stakeholderRepository.findById(request.getStakeholderId())
                .orElseThrow(() -> new RuntimeException("Stakeholder not found"));

        StakeholderBranch branch = mapper.toEntity(request, stakeholder);

        StakeholderBranch savedBranch = branchRepository.save(branch);

        return mapper.toResponse(savedBranch);
    }

    @Override
    public List<StakeholderBranchResponse> getAll() {

        return branchRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }



    @Override
    public StakeholderBranchResponse getById(String id) {

        StakeholderBranch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        return mapper.toResponse(branch);
    }

    @Override
    public StakeholderBranchResponse update(String id, StakeholderBranchRequest request) {

        StakeholderBranch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        StakeholderMaster stakeholder = stakeholderRepository.findById(request.getStakeholderId())
                .orElseThrow(() -> new RuntimeException("Stakeholder not found"));

        branch.setStakeholder(stakeholder);
        branch.setBranchFunction(request.getBranchFunction());
        branch.setBranchDescription(request.getBranchDescription());

        StakeholderBranch updatedBranch = branchRepository.save(branch);

        return mapper.toResponse(updatedBranch);
    }

    @Override
    public void delete(String id) {

        StakeholderBranch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branchRepository.delete(branch);
    }
}