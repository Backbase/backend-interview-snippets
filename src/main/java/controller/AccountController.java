package controller;

import business.Account;
import client.AccountCreationRequest;
import java.util.List;
import java.util.stream.Collectors;
import repository.AccountEntity;
import repository.AccountRepository;
// more import statements

@RestController("/accounts")
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

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createAccount(AccountCreationRequest request) {
        // implementation
        return 1L; // Account ID
    }
}
