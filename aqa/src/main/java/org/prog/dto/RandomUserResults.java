package org.prog.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandomUserResults {

    @Getter
    @Setter
    private List<PersonDto> results;
}
