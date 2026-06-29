package com.erplogic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StakeholderRequest {
    @NotBlank
    private String stakeholderName;

    @NotBlank
    private String registrationNo;

    @Email
    private String email;

    private String legalEntity;

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

    private String website;

    private Boolean active;

    private String inactiveReason;

    private String notes;
}
