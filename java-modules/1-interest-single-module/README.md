## Compile

```
javac --module-source-path src -d out $(find . -name '*.java')
```
For windows:
```
javac --module-source-path src -d out src\interest\simple\javamodule\Main.java
```

## Run

```
java --module-path out -m interest/simple.javamodule.Main
```
