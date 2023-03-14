package com.immigrant.theimmigrantdreambackend.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImmigrantStoryDto {
    private String id;
    private String firstName;
    private String lastName;
    private String hobby;
    private String origin;
    private String profession;
    private String story;
    private String quote;
}