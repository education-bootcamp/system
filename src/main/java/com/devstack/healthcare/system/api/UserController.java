package com.devstack.healthcare.system.api;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.request.RequestUserDto;
import com.devstack.healthcare.system.service.UserService;
import com.devstack.healthcare.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/visitor/signup")
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestUserDto userDto){
        userService.signup(userDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"user was saved!",
                        userDto.getFullName()),
                HttpStatus.CREATED
        );
    }

}
