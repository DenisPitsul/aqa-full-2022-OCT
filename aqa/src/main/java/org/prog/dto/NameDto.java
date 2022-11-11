package org.prog.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NameDto {

    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String first;
    @Getter
    @Setter
    private String last;
}
