package com.erplogic.api.dto;

import com.erplogic.api.utility.BranchFunction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StakeholderBranchRequest {

    private String stakeholderId;

    private BranchFunction branchFunction;

    private String branchDescription;

}
