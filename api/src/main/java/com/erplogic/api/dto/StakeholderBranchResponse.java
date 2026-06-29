package com.erplogic.api.dto;

import com.erplogic.api.utility.BranchFunction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StakeholderBranchResponse {

    private String id;

    private String stakeholderId;

    private String stakeholderName;

    private BranchFunction branchFunction;

    private String branchDescription;
}
