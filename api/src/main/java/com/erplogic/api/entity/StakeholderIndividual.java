package com.erplogic.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stakeholder_individual")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StakeholderIndividual extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id", nullable = false)
    private StakeholderMaster stakeholder;

    private String salutation;

    private String individualName;

    private String responsibility;

    private String email;

    private String phoneCode;

    private String phoneNumber;

    private String mobileCode;

    private String mobileNumber;

    private Boolean active;

    private String notes;
}