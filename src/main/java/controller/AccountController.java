package controller;

import business.Account;
import java.util.List;
import java.util.stream.Collectors;
import repository.AccountEntity;
import repository.AccountRepository;
// more import statements

@RestController("/v1/accounts")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getOpenAccounts(long typeId) {
        return accountRepository.findAllByTypeIdAndClosedFalse(typeId).stream()
            .map(this::mapFromEntity)
            .collect(Collectors.toList());
    }

    public Account mapFromEntity(AccountEntity entity) {
        Account account = new Account();
        account.setId(entity.getId());
        account.setName(entity.getName());
        account.setClosed(false);
        return account;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createAccount(@Valid @NotNull AccountCreationRequest request) {
        // implementation
        return ResponseEntity.status(HttpStatus.CREATED).body(1L); // Account ID
    }
}
