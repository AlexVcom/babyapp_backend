package com.alexandervorobiov.babyapp.SuperUser;

import com.alexandervorobiov.babyapp.Child.*;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserDto;
import com.alexandervorobiov.babyapp.SuperUser.dto.SuperUserRegistrationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


//@AllArgsConstructor
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin
public class SuperUserController {
    private final SuperUserService superUserService;
    private final ObjectMapper objectMapper;
    private final ChildService  childService;
    private final ChildRepo childRepo;


    @CrossOrigin(origins = "http://lockalhost:3000")
    @GetMapping("/admin")
    public ResponseEntity getUsers() throws JsonProcessingException { // poprawic front
        List<SuperUserDto> users = superUserService.findAllUsers();
        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity <?> getUser (@PathVariable long id) throws JsonProcessingException { //poprawic
        SuperUserDto superUser = superUserService.findUserWithDetails(id);
        return ResponseEntity.ok(objectMapper.writeValueAsString(superUser));
    }


    @CrossOrigin(origins = "http://lockalhost:3000")
    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody SuperUserRegistrationDto superUserDto) {
        Optional<SuperUserRegistrationDto> userFromDb = superUserService.findByUserName(superUserDto.getName());
        if (userFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        superUserService.saveSuperUser(superUserDto);
        return ResponseEntity.ok(HttpStatus.OK);

    }


    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@RequestBody SuperUserDto superUserDto) {
//        log.info("Request to update superUser: {id} "+superUserDto);
        SuperUser result = superUserService.updateSuperUser(superUserDto);
        return ResponseEntity.ok().body(result);
//        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        superUserService.deleteSuperUser(id);
        return ResponseEntity.ok().build();
    }















}
