package aptech.com.studentApp.Service;

import aptech.com.studentApp.dtos.RegisterDto;
import aptech.com.studentApp.dtos.RegisterResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    RegisterResponseDto registerStudent(RegisterDto registerDto);
}
