package com.entex.aplication.api.config;

import com.entex.aplication.api.dto.CountyDto;
import com.entex.aplication.api.dto.CountyListDto;
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
public class ConfigCounty {
    @Value("${spring.file-path-county}")
    private String baseUrl;

    @Bean
    public CountyListDto returnsListOfCounty() {
        CountyListDto listToReturn = CountyListDto.builder().build();
        try {
            List<CountyDto> list = new CsvToBeanBuilder(new FileReader(baseUrl)).withSkipLines(1)
                    .withType(CountyDto.class)
                    .build()
                    .parse();
            listToReturn = CountyListDto.builder().list(list).build();
        } catch (FileNotFoundException e) {
            log.error("File not found");
            e.printStackTrace();
        }
        return listToReturn;
    }
}
