package com.entex.aplication.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {


    @Schema(description = "id address", example = "1")
    private Integer id;

    @JsonProperty("user_name")
    @Schema(description = "The User name is necessary", example = "Georgescu Ion")
    private String name;

    @JsonProperty("user_email")
    @Schema(description = "The street User Data is necessary", example = "georgescu.ion@entex.com")
    private String email;

    @JsonProperty("user_password")
    @Schema(description = "The street User Data is necessary", example = "Entex-Pass7")
    private String password;

    @JsonProperty("user_phone")
    @Schema(description = "The street User Data is necessary", example = "0743.553.754")
    private String phone;

    @JsonProperty("user_comment")
    @Schema(description = "The street User Data is necessary", example = "Thank you!")
    private String comment;

    @Schema(description = "localities, if is null will not associated a localities")
    private LocalitiesDto localities;

    @Schema(description = "county, if is null will not associated a county")
    private CountyDto county;

    @Schema(description = "address, if is null will not associated a address")
    private AddressDetailsDto address;
}
