This module has no external dependencies other than java core.

## Compile

```
javac -d out src/com/mynotes/util/Interest.java src/module-info.java
```
`-d` creates the directory for us.

## Run
Usual way:
```
java -cp out com.mynotes.util.Interest
```
Modular way to run:
--module-path or -p is where we compiled the modules
--module or -m is the module to use, if we have to specify the main class, follow with a / then the fully qualified class
```
java -p out -m interest/com.mynotes.util.Interest
```

## Jars
As an alternative to linking classes, we can use jars and mods
```
rm -rf jars && mkdir jars
jar -cvfe jars/interest.jar com.mynotes.util.Interest -C out .
```
where 
* c -> create
* v ->  verbose
* f -> specifying the name of the jar
* e -> specifying name of the class
* -C -> change to out directory and add the classes from there

Check the jar's context
```
jar -tf jars/interest.jar
```
Run using the jar (no need to specify the main class as the manifest has it)
```
java -p jars -m interest
```

## Jlink
To use jlink, we have specify the module path with 
```
rm -rf jlink_image
jlink -p out --add-modules interest --launcher interest.sh=interest/com.mynotes.util.Interest --output jlink_image
```
`--add-modules` adding our modules for the path (`-p`). the rest of the Modules will be taken from JDK.
Run the launcher script:

```
sh jlink_image/bin/interest.sh
```
Check `release` file to see java version and linked modules.
Looking at what's inside out modules image:
```
jimage list jlink_image/lib/modules
```
this will list all the classes.

Now lets link our jar instead of classes:
```
rm -rf jlink_image
jlink -p jars --add-modules interest --launcher interest.sh=interest --output jlink_image
```
NOTE - no need to specify full class name now.
```
sh jlink_image/bin/interest.sh
```