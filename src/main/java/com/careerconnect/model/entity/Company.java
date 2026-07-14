package com.careerconnect.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    private String companyId;

    private String companyName;

    private String industry;

    private String location;

    private Double minimumCgpa;

    private Integer maximumBacklogs;
}
