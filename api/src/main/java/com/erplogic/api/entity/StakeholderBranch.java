package com.erplogic.api.entity;

import com.erplogic.api.utility.BranchFunction;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stakeholder_branch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StakeholderBranch extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id", nullable = false)
    private StakeholderMaster stakeholder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BranchFunction branchFunction;

    @Column(nullable = false, length = 150)
    private String branchDescription;

}
