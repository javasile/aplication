package com.entex.aplication.api.controller;

import com.entex.aplication.api.dto.UserDataDto;
import com.entex.aplication.api.exceptions.InvalidUUIDException;
import com.entex.aplication.api.service.UserDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserDataController {

    private final UserDataService userDataService;

    @Operation(summary = "GET request", description = "Get all contacts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping
    public List<UserDataDto> findAll() {
        return userDataService.findAll();
    }

    @Operation(summary = "GET request", description = "Get contact by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @GetMapping("{id}")
    public UserDataDto findById(@PathVariable Integer id) {
        return userDataService.findById(id);
    }


    @Operation(summary = "Post request", description = "Save a new contact ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PostMapping
    public UserDataDto saveNew(@RequestBody UserDataDto userDto) {
        return userDataService.saveNew(userDto);
    }

    @Operation(summary = "Put request", description = "Update contact ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @PutMapping
    public UserDataDto saveExisting(@RequestBody UserDataDto userDto) {
        return userDataService.saveExisting(userDto);
    }

    @Operation(summary = "Delete request", description = "Delete contact by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    }
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) throws InvalidUUIDException {
        userDataService.deleteById(id);
    }
}
