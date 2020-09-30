package com.alexandervorobiov.babyapp.superUser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SuperUserController {
    private final SuperUserService   superUserService;
    private final ObjectMapper objectMapper;

    @GetMapping("/admin")
    public ResponseEntity<String> getUsers() throws JsonProcessingException {
        List<SuperUserDto> users = superUserService.findAllUsers();
        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity <String> getUser (@PathVariable long id) throws JsonProcessingException { //poprawic
        SuperUserDto superUser = superUserService.findUserWithDetails(id);
        return ResponseEntity.ok(objectMapper.writeValueAsString(superUser));
    }


    @PostMapping("/users")
    public ResponseEntity <SuperUserRegistrationDto> addUser(@RequestBody SuperUserRegistrationDto superUserDto) {
        Optional<SuperUserRegistrationDto> userFromDb = superUserService.findByUserName(superUserDto.getName());
        if (userFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        superUserService.saveSuperUser(superUserDto);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/user/{id}")
    public ResponseEntity <SuperUser> updateUser(@RequestBody SuperUserDto superUserDto) {
        SuperUser result = superUserService.updateSuperUser(superUserDto);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity <Long> deleteUser(@PathVariable Long id) {
        superUserService.deleteSuperUser(id);
        return ResponseEntity.ok().build();
    }















}
