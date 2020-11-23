## Compile

```
javac --module-source-path src -d out $(find . -name '*.java')
```
For windows:
```
dir /s /B *.java > sources.txt
javac --module-source-path src -d out @sources.txt
```

## Run

```
java --module-path out -m interest.cli/javamodule.interest.cli.Main
```
