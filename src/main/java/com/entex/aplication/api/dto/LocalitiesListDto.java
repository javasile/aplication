package com.entex.aplication.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LocalitiesListDto {
    List<LocalitiesDto> list;
}
