package com.erplogic.api.config;

import com.erplogic.api.dto.StakeholderBusinessNatureRequest;
import com.erplogic.api.dto.StakeholderBusinessNatureResponse;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.entity.StakeholderBusinessNature;
import com.erplogic.api.entity.StakeholderMaster;
import org.springframework.stereotype.Component;

@Component
public class StakeholderBusinessNatureMapper {

    public StakeholderBusinessNature toEntity(
            StakeholderBusinessNatureRequest request,
            StakeholderMaster stakeholder) {

        StakeholderBusinessNature businessNature = new StakeholderBusinessNature();

        businessNature.setStakeholder(stakeholder);
        businessNature.setBusinessNature(request.getBusinessNature());

        return businessNature;
    }

    public StakeholderBusinessNatureResponse toResponse(
            StakeholderBusinessNature businessNature) {

        StakeholderBusinessNatureResponse response =
                new StakeholderBusinessNatureResponse();

        response.setId(businessNature.getId());
        response.setStakeholderId(
                businessNature.getStakeholder().getId());
        response.setStakeholderName(
                businessNature.getStakeholder().getStakeholderName());
        response.setBusinessNature(
                businessNature.getBusinessNature());

        return response;
    }
}
