package Service;

import java.util.List;

import DTO.AccountDto;
import Entity.Account;

public interface accountservice {
	
	AccountDto CreateAccount(AccountDto account);
	
	AccountDto getAccountById(Long Id);
	
	AccountDto deposit(Long Id, double amount);
	
	AccountDto withdraw(Long Id, double amount);
	
	List<AccountDto> getAllAccounts(); 
	
	void DeleteAccount(Long id);

}
