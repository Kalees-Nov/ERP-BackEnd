package com.erplogic.api.repository;

import com.erplogic.api.entity.StakeholderIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StakeholderIndividualRepository
        extends JpaRepository<StakeholderIndividual, String> {

    List<StakeholderIndividual> findByStakeholderId(String stakeholderId);

}