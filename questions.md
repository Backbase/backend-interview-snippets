# Questions about `pom.xml`
1. There is a mistake in the dependencyManagement/dependency sections, what is it?
    -> missing version in dependencyMgmt section

2. What's the command to run the plugin configured inside the `static` profile?
    -> mvn package -Pstatic

# Questions about `AccountServiceClient.java`
1. There is a Spring configuration issue in this class, what is it?
    -> missing constructor to inject `AccountsApi` instance

2. Is the logic correct in `getAccounts` method?
    -> no, it's fetching the first partition of IDs only

3. How would you fix the logic in `getAccounts` method?
    -> see the code

4. What's wrong in the `isClosed` method?
    -> it throws `RuntimeException` instead a more specific one

# Questions about `Account.java`
1. Are all fields defined with appropriate types?
    -> `Double` shouldn't be used for monetary values

2. How would you implement the `equals` method?
    -> see the code

# Questions about `ddl.sql`
1. Are relationships modelled correctly?
    -> account is missing an FK to `account_type` table

# Questions about `AccountRepository.java`
1. Is the query going to perform well for a large number of Accounts?
    -> no, it's missing indexes

2. What would happen if we have 10 million open Accounts of the same type in the database?
    -> out of memory error

# Questions about `AccountEntity.java`
1. Are all JPA annotations used correctly? Any missing?
    -> `@GeneratedValue` is missing
    
2. Is the relationship mapped in the ideal way?
    -> no, we should model account type with a separate entity class

# Questions about `AccountController.java`
1. Is this a good way to separate the code in layers?
    -> no, everything is in the controller class

2. How would separate the implementation in separate layers?
    -> see the code

3. How would you validate the request?
    -> see the code
    
4. Is this controller following REST best practices? How would you fix it?
    -> see the code
    
5. How would you introduce API versioning in this case?
    -> see the code

# Questions about `ServiceConfiguration.java`
1. How can we make sure only valid values are provided through configuration properties?
    -> add the @Validated annotation at class level and validation annotations to each field

2. Which validation annotations would you use to ensure the rules documented in javadoc are enforced?
    -> see the code

3. How can we provide a default value for `portNumber`?
    -> just initialize the field with a default value

# Questions about `dto` package
1. What are the problems with the fields defined?
    -> Tier looks like an enum

2. What do you think about the inheritance implemented, is it proper or something(s) not good?
    -> Common fields should be in `Customer`

# Questions about `CustomerService.java`
1. Is the bean stereotype correct?
    -> @Configuration -> @Service

2. How would you have implemented the `getNextTierPromotionTime(Customer)` method?
    -> Using polymorphism instead of if-else
    -> (Optional) Even instead of the service implementation, it can be provided inside the Customer classes.
        with a `getNextTierPromotionTime()` method.

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
