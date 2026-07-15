package com.careerconnect.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyResponse {

    private String companyId;
    private String companyName;
    private String industry;
    private String location;
    private Double minimumCgpa;
    private Integer maximumBacklogs;
}