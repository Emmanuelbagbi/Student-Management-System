package aptech.com.studentApp.dtos;

public class RegisterResponseDto {
    private String message;
    private Long  studentId;

    public RegisterResponseDto(String message, Long studentId){
        this.message = message;
        this.studentId = studentId;
    }
}
