package com.erplogic.api.service;

import com.erplogic.api.dto.StakeholderRequest;
import com.erplogic.api.dto.StakeholderResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeholderService {
    StakeholderResponse createStakeholder(StakeholderRequest request);

    StakeholderResponse getStakeholderById(String id);

    List<StakeholderResponse> getAllStakeholders();

    StakeholderResponse updateStakeholder(String id, StakeholderRequest request);

    void deleteStakeholder(String id);

}
