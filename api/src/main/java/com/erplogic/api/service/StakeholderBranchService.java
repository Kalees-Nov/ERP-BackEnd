package com.erplogic.api.service;

import com.erplogic.api.dto.StakeholderBranchRequest;
import com.erplogic.api.dto.StakeholderBranchResponse;

import java.util.List;

public interface StakeholderBranchService {
    StakeholderBranchResponse create(
            StakeholderBranchRequest request);

    List<StakeholderBranchResponse> getAll();

    StakeholderBranchResponse getById(String id);

    StakeholderBranchResponse update(
            String id,
            StakeholderBranchRequest request);

    void delete(String id);
}
