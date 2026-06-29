package com.erplogic.api.serviceImpl;

import com.erplogic.api.config.StakeholderMapper;
import com.erplogic.api.dto.StakeholderRequest;
import com.erplogic.api.dto.StakeholderResponse;
import com.erplogic.api.entity.StakeholderMaster;
import com.erplogic.api.repository.StakeholderRepository;
import com.erplogic.api.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeholderServiceImpl implements StakeholderService {
    @Autowired
    private final StakeholderRepository repository;
    @Autowired
    private final StakeholderMapper mapper;

    public StakeholderServiceImpl(StakeholderRepository repository, StakeholderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
@Override
    public StakeholderResponse createStakeholder(StakeholderRequest request){
        StakeholderMaster stakeholderMaster = mapper.toEntity(request);
        StakeholderMaster savedStakeholder = repository.save(stakeholderMaster);

        //StakeholderResponse stakeholderResponse = mapper.toResponse(savedStakeholder);
       return mapper.toResponse(savedStakeholder);

    }
@Override
    public StakeholderResponse getStakeholderById(String id){
        StakeholderMaster stakeholder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stakeholder not found"));
        return mapper.toResponse(stakeholder);

    }

    @Override
    public List<StakeholderResponse> getAllStakeholders(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StakeholderResponse updateStakeholder(String id, StakeholderRequest request){
        StakeholderMaster stakeholder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stakeholder not found"));
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

        StakeholderMaster updatedStakeholder = repository.save(stakeholder);

        return mapper.toResponse(updatedStakeholder);
    }

    @Override
    public void deleteStakeholder(String id){
        StakeholderMaster stakeholder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stakeholder not found"));

        repository.delete(stakeholder);
    }

}
