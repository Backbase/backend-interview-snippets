package client;

import static com.google.common.collect.ImmutableMap.toImmutableMap;

import business.Account;
import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceClient {

    private static final int PARTITION_SIZE = 12;

    private final AccountsApi accountsApi;

    public AccountServiceClient(AccountsApi accountsApi) {
        this.accountsApi = accountsApi;
    }

    /**
     * Fetches all accounts whose IDs are specified in accountIds.
     *
     * @param accountIds Collection of account IDs that should to be fetched.
     * @return Mapping of account ID to Account object.
     */
    public Map<Long, Account> getAccounts(List<String> accountIds) {
        Iterable<List<String>> partitions = Iterables.partition(accountIds, PARTITION_SIZE);
        return Streams.stream(partitions)
            .map(accountsApi::getAccounts)
            .flatMap(Collection::stream)
            .collect(toImmutableMap(Account::getId, Function.identity()));
    }

    public boolean isClosed(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return accountsApi.isClosed(id);
    }
}
