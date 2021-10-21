This module has external dependencies other than java core.

# Checking with dependencies which have Automatic-Module-Name
## Copy all the jars we need to our demo directory
While maven downloads it, let copy it locally to thats its easy to link
We are using jackson 2.9.10, because it has automatic-module name. 
Later versioned 2.10 introduce module-info.class instead. For now lets start with 2.9.10.
```
find ~/.m2 -name "jackson*.jar" | grep 2.9.10
find ~/.m2 -name "jackson-annotations*.jar" | grep 2.9.10
find ~/.m2 -name "snakeyaml*.jar" | grep 1.23
```
Copy them locally:
```
rm -rf jacksonjars && mkdir jacksonjars

cp ~/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.10/jackson-databind-2.9.10.jar \
~/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.10/jackson-core-2.9.10.jar \
~/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.10/jackson-annotations-2.9.10.jar \
~/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.9.10/jackson-dataformat-yaml-2.9.10.jar \
~/.m2/repository/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar \
jacksonjars
```

## Compile

```
javac -p jacksonjars -d out src/main/java/com/mynotes/util/JsonToYaml.java src/main/java/module-info.java
or
javac -p jacksonjars -d out $(find . -name '*.java')
```
### Check with jdeps
```
jdeps -R --module-path jacksonjars out
```
this will show all the packages and modules it depends on. Some of the modules will be shown as not found
```
jdeps -R --module-path jacksonjars out | grep 'not found'
```

To see a visual representation you can use:
```
jdeps -R --dot-output dots --module-path jacksonjars out
```
Have to install `brew install graphviz` or something similar to covert this to PNG.
```
dot dots -Tpng -O dots/summary.dot
```
open the dots/summary.dot.png

As from the commands above you will see that we also need `java.sql` in requires.

## Run
Usual way:
```
java -p out:jacksonjars  -m utils.jsonToYaml/com.mynotes.util.JsonToYaml
```
So we provided the `out` and `jacksonjars` as modules-path and then which module to run. 
Note - We did not have to add `--add-modules java.sql` because we already copiled the project again with 
`requires java.sql` in modules-info.java

```
{
  "firstName": "John",
  "lastName": "Doe",
  "gender": "man",
  "age": 24,
  "hobbies": ["movies","biking"],
  "address": {
    "streetAddress": "Udhna",
    "city": "San Jone",
    "state": "CA",
    "postalCode": "95221"
  }
}
```

## Jlink

```
rm -rf jlink_image
jlink -p out:jacksonjars --add-modules utils.jsonToYaml --launcher launcher.sh=utils.jsonToYaml/com.mynotes.util.JsonToYaml --output jlink_image
```
you get an error saying `Error: automatic module cannot be used with jlink: com.fasterxml.jackson.annotation from`

# Checking with dependencies which have module-info.class
## Copy jars locally
```
rm -rf jacksonjars && mkdir jacksonjars

cp ~/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.5/jackson-databind-2.12.5.jar \
~/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.5/jackson-core-2.12.5.jar \
~/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.5/jackson-annotations-2.12.5.jar \
~/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.12.5/jackson-dataformat-yaml-2.12.5.jar \
~/.m2/repository/org/yaml/snakeyaml/1.27/snakeyaml-1.27.jar \
jacksonjars
```

## Compile
```
javac -p jacksonjars -d out src/main/java/com/mynotes/util/JsonToYaml.java src/main/java/module-info.java
or
javac -p jacksonjars -d out $(find . -name '*.java')
```
Check with jdeps:
```
jdeps -R --module-path jacksonjars out | grep 'not found'
```
NOTE - we added `java.sql` in requires thats why this will be empty

## Run
```
java -p out:jacksonjars  -m utils.jsonToYaml/com.mynotes.util.JsonToYaml
```

## Jlink

```
rm -rf jlink_image
jlink -p out:jacksonjars --add-modules utils.jsonToYaml --launcher launcher.sh=utils.jsonToYaml/com.mynotes.util.JsonToYaml --output jlink_image
```
While jacksonjars issue is solved, you still have snakeyaml issue. We have to add the module-info.java manually to it.

```
rm -rf tmp && mkdir tmp
cd tmp
jar -xf ../jacksonjars/snakeyaml-1.27.jar
jdeps --generate-module-info . ../jacksonjars/snakeyaml-1.27.jar
javac -d . org.yaml.snakeyaml/module-info.java
jar -uf ../jacksonjars/snakeyaml-1.27.jar -C . module-info.class
cd ..
rm -rf tmp
```
Now run again jlink:
```
rm -rf jlink_image
jlink -p out:jacksonjars --add-modules utils.jsonToYaml --launcher launcher.sh=utils.jsonToYaml/com.mynotes.util.JsonToYaml --output jlink_image
```

Run the script:
```
sh jlink_image/bin/launcher.sh
```

## Jars

```
rm -rf jars && mkdir jars
rm -rf jlink_image
jar -cvfe jars/jsonToYaml.jar com.mynotes.util.JsonToYaml -C out .
```

Check the jar's context
```
jar -tf jars/jsonToYaml.jar
```
You cannot run the jar standlone like following (no need to specify the main class as the manifest has it)
```
java -p jars -m utils.jsonToYaml
```

Linking the jars:
```
jlink -p jars:jacksonjars --add-modules utils.jsonToYaml --launcher launcher.sh=utils.jsonToYaml --output jlink_image
```
Run the script:
```
sh jlink_image/bin/launcher.sh
```