package org.prog.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    private String nat;
    @Getter
    @Setter
    private NameDto name;

}
