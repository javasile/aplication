package com.entex.aplication.api.service;

import com.entex.aplication.api.dto.CountyDto;
import com.entex.aplication.api.dto.CountyListDto;
import com.entex.aplication.api.model.County;
import com.entex.aplication.api.repository.CountyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class CountyService {
    private final CountyRepository countyRepository;
    private final ModelMapper mapper;
    private final CountyListDto list;


    @PostConstruct
    @Transactional
    public void insertInDatabase() {

        countyRepository.saveAll(list.getList().stream().map(dto -> mapper.map(dto, County.class)).collect(Collectors.toList()));
    }

    public void saveAll(List<CountyDto> countyDtoList) {
        countyRepository.saveAll(mapper.map(countyDtoList, new TypeToken<ArrayList<County>>() {
        }.getType()));
    }

    public List<CountyDto> findAll() {
        return mapper.map(countyRepository.findAll(), new TypeToken<ArrayList<CountyDto>>() {
        }.getType());
    }

    public boolean deleteById(Integer id) {
        if (countyRepository.existsById(id)) {
            countyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public CountyDto save(@Valid CountyDto countyDto) {
        return mapper.map(countyRepository.save(mapper.map(countyDto, County.class)), CountyDto.class);
    }

    public CountyDto findById(Integer id) {
        return mapper.map(countyRepository.findById(id), CountyDto.class);
    }
}
