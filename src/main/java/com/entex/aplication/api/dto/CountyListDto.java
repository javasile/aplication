package com.entex.aplication.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CountyListDto {
    List<CountyDto> list;
}
