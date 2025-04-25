package aptech.com.studentApp.Service.impl;

import aptech.com.studentApp.Service.StudentService;
import aptech.com.studentApp.dtos.RegisterDto;
import aptech.com.studentApp.dtos.RegisterResponseDto;
import aptech.com.studentApp.models.Students;
import aptech.com.studentApp.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public RegisterResponseDto registerStudent(RegisterDto registerDto) {
        if(studentRepository.existsByEmail(registerDto.getEmail())){
            throw new RuntimeException("Student with email" + registerDto.getEmail() + "already exists");
        }
        Students student = new Students();
        student.setFirstName(registerDto.getFirstName());
        student.setLastName(registerDto.getLastName());
        student.setEmail(registerDto.getEmail());
        student.setPassword(registerDto.getPassword());

        Students savedRecord = studentRepository.save(student);

        return new RegisterResponseDto("Registration is successful", savedRecord.getId());

    }
}
