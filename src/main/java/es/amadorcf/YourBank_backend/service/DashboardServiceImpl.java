package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.dto.AccountResponse;
import es.amadorcf.YourBank_backend.dto.UserResponse;
import es.amadorcf.YourBank_backend.entity.Account;
import es.amadorcf.YourBank_backend.entity.User;
import es.amadorcf.YourBank_backend.exception.NotFoundException;
import es.amadorcf.YourBank_backend.repository.AccountRepository;
import es.amadorcf.YourBank_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserResponse getUserDetails(String accountNumber) {
        User user = userRepository.findByAccountAccountNumber(accountNumber);
        // Check if the user exists and is associated with the given account number
        if (user == null) {
            throw new NotFoundException("User not found for the provided account number.");
        }

        // Map the user entity to UserResponse DTO
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAddress(user.getAddress());
        userResponse.setPhone_number(user.getPhone_number());
        userResponse.setAccountNumber(user.getAccount().getAccountNumber());

        return userResponse;
    }

    @Override
    public AccountResponse getAccountDetails(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        // Check if the account exists with the provided account number
        if (account == null) {
            throw new NotFoundException("Account not found for the provided account number.");
        }

        // Map the account entity to AccountResponse DTO
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setAccountType(account.getAccount_type());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setBranch(account.getBranch());
        accountResponse.setIFSCCode(account.getIFSC_code());

        return accountResponse;
    }
}