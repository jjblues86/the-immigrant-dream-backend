package com.immigrant.theimmigrantdreambackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheImmigrantStory {

    private String id;
    private String firstName;
    private String lastName;
    private String hobby;
    private String origin;
    private String profession;
    private String story;
    private String quote;
}
