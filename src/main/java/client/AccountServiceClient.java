package client;

// import statements for java.util, Google Guava and AccountsApi classes

import business.Account;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceClient {

    private final AccountsApi accountsApi;

    /**
     * Fetches all accounts whose IDs are specified in accountIds.
     *
     * @param accountIds Collection of account IDs that should to be fetched.
     * @return Mapping of account ID to Account object.
     */
    public Map<Long, Account> getAccounts(List<String> accountIds) {
        Iterable<List<String>> partitions = Iterables.partition(accountIds, 12);
        return accountsApi.getAccounts(accountIds).stream()
            .collect(toImmutableMap(Account::getId, Function.identity()));
    }

    public boolean isClosed(String id) {
        if (id == null) {
            throw new RuntimeException("ID cannot be null");
        }
        return accountsApi.isClosed(id);
    }
}
