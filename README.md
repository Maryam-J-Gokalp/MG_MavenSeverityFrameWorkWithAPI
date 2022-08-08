# MG_MavenSeverityFrameWorkWithApi (Severity basic )


Framework for only Backend
- I used java as my programming language in my framework.
- I used maven as my built management tool. which has pom.xml file that allows me to manage my dependencies/versions easily.
- I have used JUnit5  to run and organize my test cases.
- I used Serenity to generate report and manage enviroments.
- I have restAssured library and jdbc for api and database testing.

Serenity usage.
  -I have serenity.conf file and serenity.properties file where I store my base url,
  Database connection string and one valid user credentials for each type of user.

  serenity.conf file allows me to switch between environments easily.I have same keyname with diffenrent environments so that when I want to switch I use 
  mvn clean verify -dEnvironment=...(qa2) and it runs my test cases against to env I used.
  If I dont specify it will use default environment that I set in serenity.conf file 

  I label my classes with @SerenityTest and I set my report and root name in serenity.properties file. So that tests are recognized by report.

Junit5 Usage
  I have baseclass for my project where I use @BeforeAll and @AfterAll methods to set my base_url, db connection, and close connections and reset.

  I have used regular @Tests and @ParametrizedTests from Junit5.
  @ParameterizedTests allow me to run same testcase with different sets of data which is DDT(Data Driven Testing).

  I use @MethodSource and @CsvFileSource mostly, but I know there are like ValueSource and CsvSource also. (GIVE SOME EXAMPLE BASED ON PROJECT)

RestAssured usage 
  I use Serenity version of restassured library where I have same methods in gherkin format.Gherkin allow me type readable test cases for non-technical people.If the person knows api they can easliy understand my test cases. 

  Serenity way is allowing me to get request and response in the report.I also use Ensure.that() type of verification to log each assertion that I make, to see in the report.

  I use Hamcrest matchers inside the my assertion,I use pojo my  API classes and java maps mostly to store and send request and json body.

  I have utility classes for my api and database.
  I have used database util class to create and close connection, it gets information from my serenituy.conf file and switch env dynamically. I also have ready methods to execute queries and store them the format I like,
    example: list of maps to use inputs with @MethodSource

  I also have ApiUtils we I created methods for reusable requests like generating token for different usertype. I also have some Response and RequestSpecification saved where I already defined repeated given and then sesssion. 
    Example for request: Accept,content-type,token for different user,log.
