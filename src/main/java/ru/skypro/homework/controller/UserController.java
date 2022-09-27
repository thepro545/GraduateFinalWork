package ru.skypro.homework.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CreateUserDto;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.UserService;

import java.util.Collection;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody CreateUserDto createUserDto) {

        User user = userService.createUser(mapper.createUserDtoToEntity(createUserDto));

        return ResponseEntity.ok(mapper.toDto(user));

    }


    @GetMapping("/me")
    public ResponseEntity<Collection<UserDto>> getUsers() {

        Collection<User> users = userService.getUsers();

        return ResponseEntity.ok(mapper.toDto(users));

    }

    @PatchMapping("/me")
    public UserDto update(@RequestBody UserDto userDto) {
        User user = mapper.toEntity(userDto);
        return mapper.toDto(userService.update(user));
    }


//    @PostMapping("/set_password")
//    public boolean setPassword(@RequestBody NewPasswordDto newPasswordDto) {
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id) {

        User user = userService.getUserById(id);

        return ResponseEntity.ok(mapper.toDto(user));

    }


}
