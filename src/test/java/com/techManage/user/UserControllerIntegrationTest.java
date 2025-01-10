package com.techManage.user;

import com.techManage.user.model.UserType; 
import com.techManage.user.model.User;
import com.techManage.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllUsers() throws Exception {
        User user = new User();
        user.setFullName("Sample User");
        user.setEmail("sampleuser@example.com");
        user.setPhone("+1 123 4567-8901");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setUserType(UserType.ADMIN);

        userRepository.save(user);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].fullName", is("Sample User")));
    }

    @Test
    void testGetUserById() throws Exception {
        User user = new User();
        user.setFullName("Test User");
        user.setEmail("testuser@example.com");
        user.setPhone("+1 123 4567-8901");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setUserType(UserType.ADMIN);

        User savedUser = userRepository.save(user);

        mockMvc.perform(get("/api/users/{id}", savedUser.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("Test User")))
                .andExpect(jsonPath("$.email", is("testuser@example.com")))
                .andExpect(jsonPath("$.phone", is("+1 123 4567-8901")))
                .andExpect(jsonPath("$.birthDate", is("1990-01-01")))
                .andExpect(jsonPath("$.userType", is("ADMIN")));
    }

    @Test
    void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setFullName("New User");
        newUser.setEmail("newuser@example.com");
        newUser.setPhone("+1 987 6543-2100");
        newUser.setBirthDate(LocalDate.of(1995, 5, 15));
        newUser.setUserType(UserType.ADMIN);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fullName", is("New User")))
                .andExpect(jsonPath("$.email", is("newuser@example.com")))
                .andExpect(jsonPath("$.phone", is("+1 987 6543-2100")))
                .andExpect(jsonPath("$.birthDate", is("1995-05-15")))
                .andExpect(jsonPath("$.userType", is("USER")));

        Optional<User> savedUser = userRepository.findByEmail("newuser@example.com");
        savedUser.ifPresent(user -> userRepository.deleteById(user.getId()));
    }
}