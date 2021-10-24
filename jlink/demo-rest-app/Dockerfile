FROM adoptopenjdk/openjdk11:alpine AS java-build
WORKDIR /jlink
ENV PATH $JAVA_HOME/bin:$PATH
RUN jlink --strip-debug --no-header-files --no-man-pages --compress=2 --module-path $JAVA_HOME \
    --add-modules java.base,java.desktop,java.instrument,java.management.rmi,java.naming,java.prefs,java.scripting,java.security.jgss,java.sql,jdk.httpserver,jdk.jfr,jdk.unsupported \
    --output jre-min

# Below stage to add libz.so library. else you will get following error
# java: error while loading shared libraries: libz.so.1: cannot open shared object file: No such file or directory
FROM debian:stable-slim AS build-env


FROM gcr.io/distroless/base
COPY --from=java-build /jlink/jre-min /opt/jre-min
COPY --from=build-env /lib/x86_64-linux-gnu/libz.so.1 /lib/x86_64-linux-gnu/libz.so.1
COPY ./target/demo-rest-app.jar /opt/demo/demo-rest-app.jar
ENV PATH /opt/jre-min/bin:$PATH

EXPOSE 8080
WORKDIR /
CMD ["java", "-jar", "/opt/demo/demo-rest-app.jar"]
