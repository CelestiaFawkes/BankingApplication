package Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.AccountDto;
import Entity.Account;
import Service.accountservice;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private accountservice accountService;

	public AccountController(accountservice accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	// Add Account REST API 
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountdto){
		return new ResponseEntity<>(accountService.CreateAccount(accountdto), HttpStatus.CREATED);
	}
	
	
	//Get account REST API 
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long Id){
		
		AccountDto accountDto = accountService.getAccountById(Id);
		
		return ResponseEntity.ok(accountDto);
		
		
	}
	
	//Deposit Rest API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long Id, 
			@RequestBody Map<String, Double>request){
		
		
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(Id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
		
		
	}
	
	
	//Withdraw REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long Id,
			@RequestBody Map<String,Double>request){
		
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(Id,amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//Get all accounts REST API 
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		
		List<AccountDto> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
		
	}
	
	//DeleteAccount Rest API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteAccount(@PathVariable Long Id)
	{
		accountService.DeleteAccount(Id);
		return ResponseEntity.ok("Account Deleted Successfully");
	}
	
	

}
