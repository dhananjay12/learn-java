## BUild Images

### JIB Distroless
```
mvn package jib:dockerBuild

docker run --rm -p 8080:8080 demo-rest-app:distroless
```

## Jlink

https://linuxtut.com/how-to-make-spring-boot-docker-image-smaller-51713/

Jdeps docs - https://docs.oracle.com/en/java/javase/17/docs/specs/man/jdeps.html

Get the required module with jdeps. Run the script
```
sh show-modules.sh target/demo-rest-app.jar 11
```
Copy the output to the Dockerfile first stage (already done). This is the minimum JRE it needs. 

Dockerfile is a multistage build where we took the 
distroless (https://github.com/GoogleContainerTools/distroless/tree/main/base) base image in the final stage.

Bulild docker image
```
docker build -t demo-rest-app:jlink .
```
Run and check http://localhost:8080/hello
```
docker run --rm -p 8080:8080 demo-rest-app:jlink
```

Reduce the size by more than 50%
```
$ docker images | grep demo-rest-app
demo-rest-app    jlink        012b956c0671   54 minutes ago   92.7MB
demo-rest-app    distroless   fe01325f994b   2 days ago       224MB

```

