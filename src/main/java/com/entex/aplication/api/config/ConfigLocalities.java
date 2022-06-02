package com.entex.aplication.api.config;

import com.entex.aplication.api.dto.LocalitiesDto;
import com.entex.aplication.api.dto.LocalitiesListDto;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Configuration
public class ConfigLocalities {
    @Value("${spring.file-path-locality}")
    private String baseUrl;

    @Bean
    public LocalitiesListDto returnsListOfLocalities() {
        LocalitiesListDto listToReturn = LocalitiesListDto.builder().build();
        try {
            List<LocalitiesDto> locList = new CsvToBeanBuilder(new FileReader(baseUrl)).withSkipLines(1)
                    .withType(LocalitiesDto.class)
                    .build()
                    .parse();
            listToReturn = LocalitiesListDto.builder().list(locList).build();
        } catch (FileNotFoundException e) {
            log.error("File not found");
            e.printStackTrace();
        }
        return listToReturn;
    }
}
