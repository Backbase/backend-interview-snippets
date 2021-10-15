package business;

import org.springframework.stereotype.Component;
import repository.AccountEntity;

@Component
public class AccountMapper {

    public Account mapFromEntity(AccountEntity entity) {
        Account account = new Account();
        account.setId(entity.getId());
        account.setName(entity.getName());
        account.setClosed(false);
        return account;
    }
}
