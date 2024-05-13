package Mapper;

import DTO.AccountDto;
import Entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountdto) {
		Account account = new Account(
				accountdto.getId(),
				accountdto.getAccountholdername(),
				accountdto.getBalance());
		
		return account;
	}
	
	public static AccountDto MaptoAccountDto(Account account)
	{
		AccountDto accountdto = new AccountDto(
				account.getId(),
				account.getAccountholdername(),
				account.getBalance());
		
		return accountdto;
	}
	
}
