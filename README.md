# Upic-Data-API

## Server
.war file path for the server: Server/target/SkiServlets-1.0-SNAPSHOT.war
Deploy on Tomcat and test with http://ec2-ip:8080/SkiServlet-1.0-SNAPSHOT/skiers/12/seasons/2019/day/1/skier/123

## Client 1
In "Client1/src/main/java/SkierClient.java":

edit the URL on line 15

edit the number of threads on line 13

edit the total number of threads on line 12

the number of request for each thread will be auto computed 

run the SkierClient.java

## Client 2

In "Client2/src/main/java/SkierClient.java":

edit the URL on line 21

edit the number of threads on line 19

edit the total number of threads on line 18

the number of request for each thread will be auto computed 

run the SkierClient.java
