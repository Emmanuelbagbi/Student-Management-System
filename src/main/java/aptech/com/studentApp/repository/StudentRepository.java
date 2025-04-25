package aptech.com.studentApp.repository;

import aptech.com.studentApp.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
    boolean existsByEmail(String email);
}
