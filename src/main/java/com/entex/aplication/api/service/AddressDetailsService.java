package com.entex.aplication.api.service;

import com.entex.aplication.api.dto.AddressDetailsDto;
import com.entex.aplication.api.model.AddressDetails;
import com.entex.aplication.api.repository.AddressDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class AddressDetailsService {
    private final AddressDetailsRepository addressDetailsRepository;
    private final ModelMapper mapper;

    public List<AddressDetailsDto> findAll() {
        return mapper.map(addressDetailsRepository.findAll(), new TypeToken<ArrayList<AddressDetailsDto>>() {
        }.getType());
    }

    public boolean deleteById(Integer id) {
        if (addressDetailsRepository.existsById(id)) {
            addressDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public AddressDetailsDto save(@Valid AddressDetailsDto addressDetailsDto) {
        return mapper.map(addressDetailsRepository.save(mapper.map(addressDetailsDto, AddressDetails.class)), AddressDetailsDto.class);
    }

    public AddressDetailsDto findById(Integer id) {
        return mapper.map(addressDetailsRepository.findById(id), AddressDetailsDto.class);
    }
}
