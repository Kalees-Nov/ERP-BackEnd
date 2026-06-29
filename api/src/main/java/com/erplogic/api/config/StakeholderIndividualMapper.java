package com.erplogic.api.config;

import com.erplogic.api.dto.StakeholderIndividualRequest;
import com.erplogic.api.dto.StakeholderIndividualResponse;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.entity.StakeholderIndividual;
import com.erplogic.api.entity.StakeholderMaster;
import org.springframework.stereotype.Component;

@Component
public class StakeholderIndividualMapper {

    public StakeholderIndividual toEntity(StakeholderIndividualRequest request,
                                          StakeholderMaster stakeholder) {

        StakeholderIndividual individual = new StakeholderIndividual();

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

        return individual;
    }

    public StakeholderIndividualResponse toResponse(StakeholderIndividual individual) {

        StakeholderIndividualResponse response = new StakeholderIndividualResponse();

        response.setId(individual.getId());
        response.setStakeholderId(individual.getStakeholder().getId());
        response.setStakeholderName(individual.getStakeholder().getStakeholderName());
        response.setSalutation(individual.getSalutation());
        response.setIndividualName(individual.getIndividualName());
        response.setResponsibility(individual.getResponsibility());
        response.setEmail(individual.getEmail());
        response.setPhoneCode(individual.getPhoneCode());
        response.setPhoneNumber(individual.getPhoneNumber());
        response.setMobileCode(individual.getMobileCode());
        response.setMobileNumber(individual.getMobileNumber());
        response.setActive(individual.getActive());
        response.setNotes(individual.getNotes());

        return response;
    }
}
