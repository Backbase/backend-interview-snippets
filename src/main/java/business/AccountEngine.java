package business;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import repository.AccountEntity;
import repository.AccountRepository;

@Service
public class AccountEngine {

    private final AccountRepository accountRepository;

    public AccountEngine(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findOpenAccounts(long typeId) {
        return accountRepository.findAllByTypeIdAndClosedFalse(typeId).stream()
            .map(this::mapFromEntity)
            .collect(Collectors.toList());
    }

    private Account mapFromEntity(AccountEntity entity) {
        Account account = new Account();
        account.setId(entity.getId());
        account.setName(entity.getName());
        account.setClosed(false);
        return account;
    }
}
