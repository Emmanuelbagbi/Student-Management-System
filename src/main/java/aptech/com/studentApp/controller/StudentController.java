package aptech.com.studentApp.controller;

import aptech.com.studentApp.Service.StudentService;
import aptech.com.studentApp.dtos.RegisterDto;
import aptech.com.studentApp.dtos.RegisterResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag(name = "Auth")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(summary = "This is for student registration")
    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto, BindingResult result){
        RegisterResponseDto registerStudent = studentService.registerStudent(registerDto);
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().map(error->error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseEntity<>(Map.of("errors",errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(registerStudent, HttpStatus.CREATED);
    }
}
