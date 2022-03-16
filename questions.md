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
    -> Tier can be an Enum with attributes (double promotionFactor, boolean isPromotable)
    -> Tier list is redundant
    -> Other methods could be removed after
    
# Questions about 'API-endpoints.md'
The first reaction to look for is "....ouch"

There are several ways you can use this in a question:
* You can ask for direct feedback (what is wrong?, how to do better? Do you know "REST"?) purely technical.
* You can introduce a "This is suggested by colleague - how do you react" or "Business Analyst is introducing new feature and is 'helping' the team by supplying their API design" so you can get both tech and soft-skill like providing feedback , asking question (Do we ever promote all employees?)
* Is something missing (it could use a GET maybe?)
* You can introduce as "this is the api of existing service, we want to improve, how?" and look for awareness of breaking changes.
* etc.

# Questions about security
1. The security department said that `TransferController` has security vulnerabilities, can you spot them and 
suggest fixes? (show the presence of `TokenSecurityUtils.getCurrentUser()` to the candidate)
    -> It's possible to get transfers of accounts that don't belong to the current user
    -> We should use `TokenSecurityUtils.getCurrentUser()` to find out the current user and fetch data only if it's
       related to them
