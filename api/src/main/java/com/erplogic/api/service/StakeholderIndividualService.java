package com.erplogic.api.service;

import com.erplogic.api.dto.StakeholderIndividualRequest;
import com.erplogic.api.dto.StakeholderIndividualResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StakeholderIndividualService {
    StakeholderIndividualResponse create(StakeholderIndividualRequest request);

    List<StakeholderIndividualResponse> getAll();

    StakeholderIndividualResponse getById(String id);

    StakeholderIndividualResponse update(String id,
                                         StakeholderIndividualRequest request);

    void delete(String id);
}
