package com.devstack.healthcare.system.util.mapper;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    ResponseDoctorDto toResponseDoctorDto(Doctor doctor);
    Doctor toDoctor(RequestDoctorDto dto);
    List<ResponseDoctorDto> toResponseDoctorDtoList(List<Doctor> list);
}
