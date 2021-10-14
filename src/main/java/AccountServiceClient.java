import static com.google.common.collect.ImmutableMap.toImmutableMap;

import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceClient {

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
    public Map<String, Account> getAccounts(List<String> accountIds) {
        Iterable<List<String>> partitions = Iterables.partition(accountIds, 12);
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
