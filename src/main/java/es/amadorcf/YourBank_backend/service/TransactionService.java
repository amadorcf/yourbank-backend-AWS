package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

	List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);

}
