package com.erplogic.api.repository;

import com.erplogic.api.entity.StakeholderBusinessNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeholderBusinessNatureRepository
        extends JpaRepository<StakeholderBusinessNature, String> {

    List<StakeholderBusinessNature> findByStakeholderId(String stakeholderId);

}
