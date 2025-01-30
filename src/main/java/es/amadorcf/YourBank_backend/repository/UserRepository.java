package es.amadorcf.YourBank_backend.repository;

import es.amadorcf.YourBank_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

	User findByAccountAccountNumber(String accountNumber);

    boolean existsByEmail(String email);
}
