package com.entex.aplication.api.service;

import com.entex.aplication.api.dto.LocalitiesDto;
import com.entex.aplication.api.dto.LocalitiesListDto;
import com.entex.aplication.api.model.Localities;
import com.entex.aplication.api.repository.LocalitiesRepository;
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

@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class LocalitiesService {

    public final LocalitiesRepository localitiesRepository;
    public final ModelMapper mapper;
    public final LocalitiesListDto list;


    @PostConstruct
    @Transactional
    public void insertInDatabase() {
        list.getList().stream().forEach(System.out::println);

        this.saveAll(list.getList());
    }

    public void saveAll(List<LocalitiesDto> localitiesDtoList) {
        localitiesRepository.saveAll(mapper.map(localitiesDtoList, new TypeToken<ArrayList<Localities>>() {
        }.getType()));
    }

    public List<LocalitiesDto> findAll() {
        return mapper.map(localitiesRepository.findAll(), new TypeToken<ArrayList<LocalitiesDto>>() {
        }.getType());
    }

    public boolean deleteById(Integer id) {
        if (localitiesRepository.existsById(id)) {
            localitiesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public LocalitiesDto save(@Valid LocalitiesDto localitiesDtoList) {
        return mapper.map(localitiesRepository.save(mapper.map(localitiesDtoList, Localities.class)), LocalitiesDto.class);
    }

    public LocalitiesDto findById(Integer id) {
        return mapper.map(localitiesRepository.findById(id), LocalitiesDto.class);
    }
}
