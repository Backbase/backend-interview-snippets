package business;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

@Service
public class AccountEngine {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountEngine(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<Account> findOpenAccounts(long typeId) {
        return accountRepository.findAllByTypeIdAndClosedFalse(typeId).stream()
            .map(accountMapper::mapFromEntity)
            .collect(Collectors.toList());
    }
}
