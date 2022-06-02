package com.entex.aplication.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDetailsDto {


    @Schema(description = "id address", example = "1")
    private Integer id;


    @Schema(description = "The street User Data is necessary", example = "Str. Matei Corvin")
    private String street;


    @Schema(description = "The street number User Data is necessary", example = "Nr. 132A, Sc.B, Et. 1, Ap.6")
    private String number;


    @Schema(description = "The street User Data is necessary", example = "500449")
    private String postalCode;
}
