package com.immigrant.theimmigrantdreambackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImmigrantBusinessDto {
    private String id;
    private String businessDescription;
    private String businessLocation;
    private String businessName;
    private String businessType;
    private String businessWebsite;
}
