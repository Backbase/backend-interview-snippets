# Questions about `pom.xml`
1. There is a mistake in the dependencyManagement/dependency sections, what is it?
2. What's the command to activate the `static` profile? How does maven decide to run `frontend-maven-plugin` during the build?

# Questions about `AccountServiceClient.java`
1. There is a Spring configuration issue in this class, what is it?
2. Is the logic correct in `getAccounts` method? How can we fix it?
4. There is a bad coding practice in the `isClosed` method, can you spot it?

# Questions about `Account.java`
1. Are all fields defined with appropriate types?
2. How would you implement the `equals` method?

# Questions about `ddl.sql`
1. Is the one to many relationship modelled correctly?

# Questions about `AccountRepository.java`
1. Is the query going to perform well for a large number of Accounts? How can we make sure it does?

# Questions about `AccountController.java`
1. How would separate the implementation in separate layers?
2. Is this controller following REST best practices? How would you fix it?
3. How would you introduce API versioning in this case?

# Questions about `ServiceConfiguration.java`
1. How can we make sure only valid values are provided through configuration properties?
2. Which validation annotations would you use to ensure the rules documented in javadoc are enforced?
3. How can we provide a default value for `portNumber`?

# Questions about `dto` package
1. What are the problems with the fields defined?
2. What do you think about the inheritance implemented, is it proper or something(s) not good?

# Questions about `CustomerService.java`
1. Is the bean stereotype correct?
2. How would you have implemented the `getNextTierPromotionTime(Customer)` method?
3. What do you think about the other parts of the class? How would you refactor?
    
# Questions about 'openapi.yaml' (use your IDE's support for folding code to present all endpoints in a single page)
1. The business analyst has decided to help the team by supplying an API spec, what do you think about its design?

# Questions about security
1. The security department said that `TransferController` has security vulnerabilities, can you spot them and 
suggest fixes? (show the presence of `TokenSecurityUtils.getCurrentUser()` to the candidate)
