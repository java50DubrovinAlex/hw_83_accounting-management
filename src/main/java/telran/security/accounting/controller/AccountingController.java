package telran.security.accounting.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import telran.security.accounting.dto.AccountDto;
import telran.security.accounting.dto.PasswordUpdateDto;
import telran.security.accounting.service.AccountingService;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountingController {
	final AccountingService accountingService;
	@PostMapping
	AccountDto addAccount(@RequestBody @Valid AccountDto accountDto) {
		return accountingService.addAccount(accountDto);
	}
	@DeleteMapping("{email}")
	AccountDto removeAccount(@PathVariable String email) {
		return accountingService.removeAccount(email);
	}
	@PutMapping
	PasswordUpdateDto updatePassword(@RequestBody @Valid PasswordUpdateDto update) {
		accountingService.updatePassword(update.email(), update.newPassword());
		return update;
	}
}
