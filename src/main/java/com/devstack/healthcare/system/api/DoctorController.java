package com.devstack.healthcare.system.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @PostMapping
    public String createDoctor(){
        return "createDoctor";
    }

    @GetMapping
    public String findDoctor(){
        return "findDoctor";
    }

    @PutMapping
    public String updateDoctor(){
        return "updateDoctor";
    }

    @DeleteMapping
    public String deleteDoctor(){
        return "deleteDoctor";
    }

    @GetMapping(path = "/list")
    public String findAllDoctors(){
        return "findAllDoctors";
    }
}
