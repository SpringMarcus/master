This project has been built of from
http://websystique.com/springmvc/spring-4-mvc-and-hibernate4-integration-example-using-annotations/

STEPS TO RUN THIS PROJECT
1. Launch a MySQL server on your local machine
2. create a database named "Justin"
3. run the data definition language ddl.spl script in the Justin database
4. edit the order.manager.properties files:
   - /src/main/resources/order.manager.properties
   - /src/main/resources/marcus.chiu_order.manager.properties
5. mvn clean install -Dmaven.test.skip=true
6. connect to Tomcat Server and run this baby!