package com.careerconnect.mapper;

import com.careerconnect.dto.request.StudentRequest;
import com.careerconnect.dto.response.StudentResponse;
import com.careerconnect.model.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request){

        return Student.builder()
                .studentId(request.getStudentId())
                .name(request.getName())
                .email(request.getEmail())
                .programme(request.getProgramme())
                .graduationYear(request.getGraduationYear())
                .cgpa(request.getCgpa())
                .activeBacklogs(request.getActiveBacklogs())
                .skills(request.getSkills())
                .build();

    }

    public StudentResponse toResponse(Student student){

        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .email(student.getEmail())
                .programme(student.getProgramme())
                .graduationYear(student.getGraduationYear())
                .cgpa(student.getCgpa())
                .activeBacklogs(student.getActiveBacklogs())
                .skills(student.getSkills())
                .build();

    }

}