package com.erplogic.api.service;

import com.erplogic.api.dto.StakeholderBusinessNatureRequest;
import com.erplogic.api.dto.StakeholderBusinessNatureResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StakeholderBusinessNatureService {

    StakeholderBusinessNatureResponse create(
            StakeholderBusinessNatureRequest request);

    List<StakeholderBusinessNatureResponse> getAll();

    StakeholderBusinessNatureResponse getById(String id);

    StakeholderBusinessNatureResponse update(
            String id,
            StakeholderBusinessNatureRequest request);

    void delete(String id);

}
