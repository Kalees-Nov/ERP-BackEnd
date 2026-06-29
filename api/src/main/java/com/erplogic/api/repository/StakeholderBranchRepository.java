package com.erplogic.api.repository;

import com.erplogic.api.entity.StakeholderBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeholderBranchRepository
        extends JpaRepository<StakeholderBranch, String> {

    List<StakeholderBranch> findByStakeholderId(String stakeholderId);

}
