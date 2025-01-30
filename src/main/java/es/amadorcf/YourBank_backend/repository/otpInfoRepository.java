package es.amadorcf.YourBank_backend.repository;

import es.amadorcf.YourBank_backend.entity.OtpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface otpInfoRepository extends JpaRepository<OtpInfo, Long> {

	OtpInfo findByAccountNumberAndOtp(String accountNumber, String otp);
	
	OtpInfo findByAccountNumber(String accountNumber);

}
