package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.dto.AccountResponse;
import es.amadorcf.YourBank_backend.dto.UserResponse;

public interface DashboardService {
    UserResponse getUserDetails(String accountNumber);
    AccountResponse getAccountDetails(String accountNumber);
}