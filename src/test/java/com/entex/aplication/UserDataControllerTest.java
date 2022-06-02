//package com.entex.aplication;
//
//import com.entex.aplication.api.dto.UserDataDto;
//import com.entex.aplication.api.model.UserData;
//import com.entex.aplication.api.repository.UserDataRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserDataControllerTest {
//
//
//        @Autowired
//        private MockMvc mvc;
//
//        @Autowired
//        private ObjectMapper objectMapper;
//
//        @Autowired
//        private UserDataRepository userDataRepository;
//        private UserData userData;
//
//        @BeforeEach
//        public void cleanupDatabase() {
//            userData = UserData.builder()
//                    .name("Georgescu Ion")
//                    .email("georgescu.ion@entex.com")
//                    .password("Entex-Pass7")
//                    .phone("0743.553.754")
//                    .comment("Thank you!")
//                    .localities(null)
//                    .county(null)
//                    .address(null)
//                    .build();
//            userDataRepository.deleteAll();
//            userData = userDataRepository.save(userData);
//        }
//
//        @Test
//        void testCRUD() throws Exception {
//            UserDataDto userDataDto = UserDataDto.builder()
//                    .id(userData.getId())
//                    .name("Georgescu Ion")
//                    .email("georgescu.ion@entex.com")
//                    .password("Entex-Pass7")
//                    .phone("0743.553.754")
//                    .comment("Thank you!")
//                    .localities(null)
//                    .county(null)
//                    .address(null)
//                    .build();
//            mvc.perform(get("/user")
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                    .andExpect(content().json(objectMapper.writeValueAsString(List.of(userDataDto))));
//            mvc.perform(put("/user")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(userDataDto)))
//                    .andExpect(status().isOk())
//                    .andExpect(content().json(objectMapper.writeValueAsString(userDataDto)));
//            mvc.perform(get("/user/{id}", userDataDto.getId())
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(content().json(objectMapper.writeValueAsString(userDataDto)));
//            mvc.perform(delete("/user/{id}", userDataDto.getId())
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk());
//            userDataDto.setId(null);
//            mvc.perform(post("/user")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(userDataDto)))
//                    .andExpect(status().isOk());
//        }
//
//
//
//}
