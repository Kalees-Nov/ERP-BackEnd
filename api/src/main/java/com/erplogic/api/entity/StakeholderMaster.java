package com.erplogic.api.entity;


import com.erplogic.api.utility.StakeholderClassification;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stakeholder_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StakeholderMaster extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StakeholderClassification stakeholderClassification;

    @Column(nullable = false, unique = true)
    private String stakeholderName;

    private String legalEntity;

    @Column(unique = true)
    private String registrationNo;

    private Boolean multipleLocation;

    private Boolean sstApplicable;

    private String sstNo;

    private Boolean gstApplicable;

    private String gstNo;

    private String bankName;

    private String accountNo;

    private String address1;

    private String address2;

    private String address3;

    private String postcode;

    private String city;

    private String state;

    private String phone1Code;

    private String phone1;

    private String phone2Code;

    private String phone2;

    private String phone3Code;

    private String phone3;

    private String email;

    private String website;

    private Boolean active;

    private String inactiveReason;

    @Column(length = 1000)
    private String notes;

    @OneToMany(mappedBy = "stakeholder",
            cascade = CascadeType.ALL)
    private List<StakeholderBranch> branches = new ArrayList<>();

    @OneToMany(
            mappedBy = "stakeholder",
            cascade = CascadeType.ALL
    )
    private List<StakeholderIndividual> individuals = new ArrayList<>();
}
