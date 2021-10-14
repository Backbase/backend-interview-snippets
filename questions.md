# Questions about `pom.xml`
1. There is a mistake in the dependencyManagement/dependency sections, what is it? -> missing version in dependencyMgmt section
2. What's the command to run the plugin configured inside the `static` profile? -> mvn package -Pstatic

# Questions about `AccountServiceClient.java`
1. There is a Spring configuration issue in this class, what is it? -> missing constructor to inject `AccountsApi` instance
2. Is the logic correct in `getAccounts` method? -> no, it's fetching the first partition of IDs only
3. How would you fix the logic in `getAccounts` method? -> see the code
4. What's wrong in the `isClosed` method? -> it throws `RuntimeException` instead a more specific one

# Questions about `Account.java`
1. Are all fields defined with appropriate types? -> `Double` shouldn't be used for monetary values
2. How would you implement the `equals` method? -> see the code
