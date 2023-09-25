package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.entity.Doctor;
import com.devstack.healthcare.system.repo.DoctorRepo;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {

        UUID uuid= UUID.randomUUID();
        long docId= uuid.getMostSignificantBits();

        Doctor doctor =new Doctor(
                docId, dto.getName(), dto.getAddress(),
                dto.getContact(), dto.getSalary()
        );

        doctorRepo.save(doctor);
    }

    @Override
    public ResponseDoctorDto getDoctor(long id) {
        return null;
    }

    @Override
    public void deleteDoctor(long id) {

    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto dto) {

    }

    @Override
    public List<ResponseDoctorDto> getAllDoctors(String searchText, int page, int size) {
        return null;
    }
}
