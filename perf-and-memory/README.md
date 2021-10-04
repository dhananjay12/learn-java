## Jconsole

You can use Jconsole to monitor the code cache. You might have to give rights to a folder for Jconsole to see

Just type in `jconsole` in terminal.

## JITWatch

JITWatch is an active open source project hosted at https://github.com/AdoptOpenJDK/jitwatch.

The typical commands for installing JITWatch are as follows:

```xml
git clone git@github.com:AdoptOpenJDK/jitwatch.git
cd jitwatch
mvn clean install -DskipTests=true
mvn exec:java
```
