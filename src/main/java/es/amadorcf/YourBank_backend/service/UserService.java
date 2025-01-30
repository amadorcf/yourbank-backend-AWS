package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.entity.User;

public interface UserService {
	public User registerUser(User user);

	User getUserByAccountNumber(String account_no);

	public void saveUser(User user);

	User updateUser(User user);

	User getUserByEmail(String email);
}
