package com.entex.aplication.api.service;

import com.entex.aplication.api.dto.UserDataDto;
import com.entex.aplication.api.exceptions.EmailAddressExistsException;
import com.entex.aplication.api.exceptions.InvalidUUIDException;
import com.entex.aplication.api.model.UserData;
import com.entex.aplication.api.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
@Slf4j
@RequiredArgsConstructor
@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;
    private final ModelMapper mapper;

    public List<UserDataDto> findAll() {
        return mapper.map(userDataRepository.findAll(), new TypeToken<ArrayList<UserDataDto>>() {
        }.getType());
    }

    public boolean deleteById(Integer id) {
        if (userDataRepository.existsById(id)) {
            userDataRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDataDto saveNew(@Valid UserDataDto userDataDto) {
        if (userDataRepository.existsUserDataByEmail(userDataDto.getEmail())) {
            throw new EmailAddressExistsException();
        } else {
            return mapper.map(userDataRepository.save(mapper.map(userDataDto, UserData.class)), UserDataDto.class);
        }
    }

    public UserDataDto findById(Integer id) {
        return mapper.map(userDataRepository.findById(id), UserDataDto.class);
    }

    public UserDataDto saveExisting(@Valid UserDataDto userDataDto) {
        if (userDataRepository.existsById(userDataDto.getId())) {
            throw new InvalidUUIDException();
        } else {
            return mapper.map(userDataRepository.save(mapper.map(userDataDto, UserData.class)), UserDataDto.class);
        }
    }
}
