# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.3/maven-plugin/build-image.html)
* [Java Mail Sender](https://docs.spring.io/spring-boot/3.4.3/reference/io/email.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.4.3/reference/data/nosql.html#data.nosql.mongodb)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.4.3/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Config Client](https://docs.spring.io/spring-cloud-config/reference/client.html)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/reference/spring-cloud-netflix.html#_service_discovery_eureka_clients)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/3.4.3/reference/messaging/kafka.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

