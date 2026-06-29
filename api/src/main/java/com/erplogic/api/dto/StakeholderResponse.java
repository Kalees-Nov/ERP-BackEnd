package com.erplogic.api.dto;

import lombok.*;

@Getter
@Setter
public class StakeholderResponse {
    private String id;

    private String stakeholderName;

    private String registrationNo;

    private String legalEntity;

    private String email;

    private Boolean active;
}
