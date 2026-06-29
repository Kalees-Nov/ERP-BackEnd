package com.erplogic.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stakeholder_business_nature")
@Getter
@Setter
public class StakeholderBusinessNature extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id", nullable = false)
    private StakeholderMaster stakeholder;

    @Column(nullable = false)
    private String businessNature;
}