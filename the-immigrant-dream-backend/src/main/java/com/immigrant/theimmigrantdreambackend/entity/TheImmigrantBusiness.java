package com.immigrant.theimmigrantdreambackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheImmigrantBusiness {

    private String id;
    private String businessDescription;
    private String businessLocation;
    private String businessName;
    private String businessType;
    private String businessWebsite;
}
