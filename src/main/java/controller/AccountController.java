package controller;

import business.Account;
import business.AccountEngine;
import client.AccountCreationRequest;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/accounts")
public class AccountController {

    private final AccountEngine accountEngine;

    public AccountController(AccountEngine accountEngine) {
        this.accountEngine = accountEngine;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getOpenAccounts(long typeId) {
        return accountEngine.findOpenAccounts(typeId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createAccount(@Valid @NotNull AccountCreationRequest request) {
        // implementation
        return ResponseEntity.status(HttpStatus.CREATED).body(1L); // Account ID
    }
}
