package com.erplogic.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StakeholderIndividualRequest {

    private String stakeholderId;

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