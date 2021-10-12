// import statements for java.util, Google Guava and AccountsApi classes

@Component
public class AccountServiceClient {

    public static final int PARTITION_SIZE = 10;

    private final AccountsApi accountsApi;

    /**
     * Fetches all accounts whose IDs are specified in accountIds.
     *
     * @param accountIds Collection of account IDs that should to be fetched.
     * @return Mapping of account ID to Account object.
     */
    @Override
    public Map<String, Account> getAccounts(List<String> accountIds) {
        Iterable<List<String>> partitions = Iterables.partition(accountIds, PARTITION_SIZE);
        return accountsApi.getAccounts(ids).stream()
            .collect(toImmutableMap(Account::getId, Function.identity()));
    }
}
