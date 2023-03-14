package com.immigrant.theimmigrantdreambackend.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImmigrantStoryDto {
    private String id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String hobby;
    @NotEmpty
    private String origin;
    @NotEmpty
    private String profession;
    @NotEmpty
    private String story;
    @NotEmpty
    private String quote;
}