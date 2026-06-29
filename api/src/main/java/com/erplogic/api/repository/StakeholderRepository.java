package com.erplogic.api.repository;

import com.erplogic.api.entity.StakeholderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StakeholderRepository extends JpaRepository<StakeholderMaster,String> {
}
