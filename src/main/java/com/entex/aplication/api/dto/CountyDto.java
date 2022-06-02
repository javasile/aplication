package com.entex.aplication.api.dto;

import com.opencsv.bean.CsvBindByPosition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountyDto {

    @CsvBindByPosition(position = 0)
    @Schema(description = "id address", example = "1")
    private Integer id;

    @Schema(description = "Exact date of occurrence for the reported event (or starting date of occurrence, if county_name exists) ")
    @CsvBindByPosition(position = 1)
    private String name;

    @Schema(description = "Exact date of occurrence for the reported event (or starting date of occurrence, if county_code exists) ")
    @CsvBindByPosition(position = 2)
    private String code;

}
