package com.erplogic.api.config;

import com.erplogic.api.dto.StakeholderBranchRequest;
import com.erplogic.api.dto.StakeholderBranchResponse;
import com.erplogic.api.entity.StakeholderBranch;
import com.erplogic.api.entity.StakeholderMaster;
import org.springframework.stereotype.Component;

@Component
public class StakeholderBranchMapper {
    public StakeholderBranch toEntity(StakeholderBranchRequest request,
                                      StakeholderMaster stakeholder){

        StakeholderBranch branch = new StakeholderBranch();

        branch.setStakeholder(stakeholder);
        branch.setBranchFunction(request.getBranchFunction());
        branch.setBranchDescription(request.getBranchDescription());

        return branch;
    }

    public StakeholderBranchResponse toResponse(StakeholderBranch branch){

        StakeholderBranchResponse response =
                new StakeholderBranchResponse();

        response.setId(branch.getId());

        response.setStakeholderId(
                branch.getStakeholder().getId());

        response.setStakeholderName(
                branch.getStakeholder().getStakeholderName());

        response.setBranchFunction(
                branch.getBranchFunction());

        response.setBranchDescription(
                branch.getBranchDescription());

        return response;
    }

}
