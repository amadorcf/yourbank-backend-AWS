package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.dto.TransactionDTO;
import es.amadorcf.YourBank_backend.entity.Transaction;
import es.amadorcf.YourBank_backend.mapper.TransactionMapper;
import es.amadorcf.YourBank_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	 @Autowired
	    private TransactionMapper transactionMapper;

	 @Override
	 public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber) {
	     List<Transaction> transactions = transactionRepository.findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(accountNumber, accountNumber);
	     
	     List<TransactionDTO> transactionDTOs = transactions.stream()
	             .map(transactionMapper::toDto)
	             .sorted((t1, t2) -> t2.getTransaction_date().compareTo(t1.getTransaction_date()))
	             .collect(Collectors.toList());

	     return transactionDTOs;
	 }


}
