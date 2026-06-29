package com.erplogic.api.config;

import com.erplogic.api.dto.StakeholderRequest;
import com.erplogic.api.dto.StakeholderResponse;
import com.erplogic.api.entity.StakeholderMaster;
import org.springframework.stereotype.Component;

@Component
public class StakeholderMapper {
    public StakeholderMaster toEntity(StakeholderRequest request){

        if(request == null)
            return null;
        StakeholderMaster stakeholder = new StakeholderMaster();
        stakeholder.setStakeholderName(request.getStakeholderName());
        stakeholder.setRegistrationNo(request.getRegistrationNo());
        stakeholder.setEmail(request.getEmail());
        stakeholder.setLegalEntity(request.getLegalEntity());

        stakeholder.setMultipleLocation(request.getMultipleLocation());

        stakeholder.setSstApplicable(request.getSstApplicable());
        stakeholder.setSstNo(request.getSstNo());

        stakeholder.setGstApplicable(request.getGstApplicable());
        stakeholder.setGstNo(request.getGstNo());

        stakeholder.setBankName(request.getBankName());
        stakeholder.setAccountNo(request.getAccountNo());

        stakeholder.setAddress1(request.getAddress1());
        stakeholder.setAddress2(request.getAddress2());
        stakeholder.setAddress3(request.getAddress3());

        stakeholder.setPostcode(request.getPostcode());
        stakeholder.setCity(request.getCity());
        stakeholder.setState(request.getState());

        stakeholder.setPhone1Code(request.getPhone1Code());
        stakeholder.setPhone1(request.getPhone1());

        stakeholder.setPhone2Code(request.getPhone2Code());
        stakeholder.setPhone2(request.getPhone2());

        stakeholder.setPhone3Code(request.getPhone3Code());
        stakeholder.setPhone3(request.getPhone3());

        stakeholder.setWebsite(request.getWebsite());

        stakeholder.setActive(request.getActive());

        stakeholder.setInactiveReason(request.getInactiveReason());

        stakeholder.setNotes(request.getNotes());
        stakeholder.setStakeholderClassification(request.getStakeholderClassification());

        return stakeholder;

    }

    public StakeholderResponse toResponse(StakeholderMaster stakeholderResponse){
        if (stakeholderResponse == null) {
            return null;
        }

        StakeholderResponse response = new StakeholderResponse();

        response.setId(stakeholderResponse.getId());
        response.setStakeholderName(stakeholderResponse.getStakeholderName());
        response.setRegistrationNo(stakeholderResponse.getRegistrationNo());
        response.setEmail(stakeholderResponse.getEmail());
        response.setLegalEntity(stakeholderResponse.getLegalEntity());
        response.setActive(stakeholderResponse.getActive());
        return response;
    }
}
