1.To Write Junnit-Mockito-Test Cases 

Two Dependencies are required

		<!-- Spring Boot Starter Test -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- JUnit Jupiter Engine -->
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<scope>test</scope>
		</dependency>

2.After That Whata-ever test classes created by programmer annotate with @DataJpaTest
@DataJpaTest means This annotation will set up Spring Data JPA for testing
