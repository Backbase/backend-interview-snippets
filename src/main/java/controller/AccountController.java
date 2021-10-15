package controller;

import business.Account;
import business.AccountEngine;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountEngine accountEngine;

    public AccountController(AccountEngine accountEngine) {
        this.accountEngine = accountEngine;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getOpenAccounts(long typeId) {
        return accountEngine.findOpenAccounts(typeId);
    }
}
