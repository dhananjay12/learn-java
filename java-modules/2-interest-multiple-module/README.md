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

## Jlink
Compile all
```
javac --module-source-path src -d out $(find . -name '*.java')
```
Create jars
```
rm -rf jars && mkdir -p jars
jar --create --file jars/interest.core.jar -C out/interest.core .
jar --create --file jars/interest.cli.jar -C out/interest.cli .
```

Create image
```
rm -rf image && \
jlink --module-path jars/:$JAVA_HOME/jmods \
--add-modules interest.cli \
--strip-debug \
--compress=2 \
--output image

```

```
jpackage --runtime-image my-custom-jre-with-app --module-path jars/:$JAVA_HOME/jmods \
--add-modules interest.cli \
--strip-debug \
--compress=2 \
--output image```
Check image folder size
```
du -hs image
```

List modules in image

```
./image/bin/java --list-modules
```

```
jpackage \
--runtime-image my-custom-jre-with-app \
--module interest.cli/javamodule.interest.cli.Main
```