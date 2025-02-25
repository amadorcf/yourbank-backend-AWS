package es.amadorcf.YourBank_backend.service;

import es.amadorcf.YourBank_backend.entity.Account;
import es.amadorcf.YourBank_backend.entity.User;
import es.amadorcf.YourBank_backend.exception.UserValidation;
import es.amadorcf.YourBank_backend.repository.UserRepository;
import es.amadorcf.YourBank_backend.util.LoggedinUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, AccountService accountService,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.passwordEncoder =  passwordEncoder;
    }
    
    @Override
    public User getUserByAccountNumber(String account_no) {
    	return userRepository.findByAccountAccountNumber(account_no);
    }
    
    @Override
    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserValidation("User already exists");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Save the user details
        User savedUser = userRepository.save(user);

        // Create an account for the user
        Account account = accountService.createAccount(savedUser);

        savedUser.setAccount(account);
        userRepository.save(savedUser);
        
        System.out.println(savedUser.getAccount().getAccountNumber());
        System.out.println(account.getUser().getName());

        return savedUser;
    }

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findByAccountAccountNumber(LoggedinUser.getAccountNumber());
        if(user.getEmail() != null){
            if(user.getEmail().isEmpty())
                throw new UserValidation("Email can't be empty");
            else
                existingUser.setEmail(user.getEmail());
        }
        if(user.getName() != null){
            if(user.getName().isEmpty())
                throw new UserValidation("Name can't be empty");
            else
                existingUser.setName(user.getName());
        }
        if(user.getPhone_number() != null){
            if(user.getPhone_number().isEmpty())
                throw new UserValidation("Phone number can't be empty");
            else
                existingUser.setPhone_number(user.getPhone_number());
        }
        if(user.getAddress() != null){
            existingUser.setAddress(user.getAddress());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
