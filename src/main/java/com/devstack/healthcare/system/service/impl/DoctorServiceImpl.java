package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.entity.Doctor;
import com.devstack.healthcare.system.repo.DoctorRepo;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    // crud, exception, mapping
    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {

        UUID uuid = UUID.randomUUID();
        long docId = uuid.getMostSignificantBits();

        Doctor doctor = new Doctor(
                docId, dto.getName(), dto.getAddress(),
                dto.getContact(), dto.getSalary()
        );

        doctorRepo.save(doctor);
    }

    @Override
    public ResponseDoctorDto getDoctor(long id) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()) {
            throw new RuntimeException("Doctor Not Found");
        }
        Doctor doc = selectedDoctor.get();
        return new ResponseDoctorDto(
                doc.getId(), doc.getName(),
                doc.getAddress(), doc.getContact(), doc.getSalary()
        );
    }

    @Override
    public void deleteDoctor(long id) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()) {
            throw new RuntimeException("Doctor Not Found");
        }
        doctorRepo.deleteById(selectedDoctor.get().getId());
    }

    @Override
    public List<ResponseDoctorDto> findDoctorsByName(String name) {
        List<Doctor> allByName = doctorRepo.findAllByName(name);
        return null;
    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto dto) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()) {
            throw new RuntimeException("Doctor Not Found");
        }
        Doctor doc = selectedDoctor.get();
        doc.setName(dto.getName());
        doc.setAddress(dto.getAddress());
        doc.setSalary(dto.getSalary());
        doc.setContact(dto.getContact());
        doctorRepo.save(doc);
    }

    @Override
    public List<ResponseDoctorDto> getAllDoctors(String searchText, int page, int size) {
        searchText = "%" + searchText + "%";
        List<Doctor> doctors = doctorRepo.searchDoctors(searchText, PageRequest.of(page, size));
        List<ResponseDoctorDto> dtos = new ArrayList<>();
        doctors.forEach(doc->{
            dtos.add(
                    new ResponseDoctorDto(
                            doc.getId(), doc.getName(),
                            doc.getAddress(), doc.getContact(), doc.getSalary()
                    )
            );
        });
        return dtos;
    }
}
