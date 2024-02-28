# steps
- go to docker file folder
- docker build -t spring-demo:1.0 .
- docker run -d -p 8080:8080 spring-demo:1.0 --name spring-container
- docker ps -a && docker log
- check http://localhost:8080/messages