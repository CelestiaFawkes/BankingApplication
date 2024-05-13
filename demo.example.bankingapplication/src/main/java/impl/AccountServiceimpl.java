package impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import DTO.AccountDto;
import Entity.Account;
import Mapper.AccountMapper;
import Repository.AccountRepository;
import Service.accountservice;


@Service
public class AccountServiceimpl implements accountservice {

	private AccountRepository accountRepository;



	public AccountServiceimpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto CreateAccount(AccountDto accountdto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountdto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.MaptoAccountDto(savedAccount);
	}


	@Override
	public AccountDto getAccountById(Long Id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.MaptoAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long Id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account savedaccount = accountRepository.save(account);
		return AccountMapper.MaptoAccountDto(savedaccount);
	}


	@Override
	public AccountDto withdraw(Long Id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		if(account.getBalance() < amount)
		{
			throw new RuntimeException("Insufficient Balance");
		}

		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account savedaccount = accountRepository.save(account);
		return AccountMapper.MaptoAccountDto(savedaccount);

	}


	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.MaptoAccountDto(account))
		.collect(Collectors.toList());
		

	}


	@Override
	public void DeleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		accountRepository.deleteById(id);
		

		

		
		
	}




}
