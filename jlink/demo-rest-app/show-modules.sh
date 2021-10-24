#!/bin/sh
# jdeps-spring-boot

set -eu

readonly TARGET_JAR=$1
readonly TARGET_VER=$2

#Directory to extract the jar
readonly TMP_DIR="/tmp/app-jar"
mkdir -p ${TMP_DIR}
trap 'rm -rf ${TMP_DIR}' EXIT

#Extract the jar
unzip -q "${TARGET_JAR}" -d "${TMP_DIR}"

#output
jdeps \
    -classpath \'${TMP_DIR}/BOOT-INF/lib/*:${TMP_DIR}/BOOT-INF/classes:${TMP_DIR}\' \
    --print-module-deps \
    --ignore-missing-deps \
    --module-path ${TMP_DIR}/BOOT-INF/lib/jakarta.annotation-api-1.3.5.jar \
    --recursive \
    --multi-release ${TARGET_VER} \
    -quiet \
    ${TMP_DIR}/org ${TMP_DIR}/BOOT-INF/classes ${TMP_DIR}/BOOT-INF/lib/*.jar

#$sh show-modules.sh target/demo-rest-app.jar 11
#Exception in thread "main" java.lang.module.FindException: Module java.annotation not found, required by org.apache.tomcat.embed.core
#        at java.base/java.lang.module.Resolver.findFail(Resolver.java:893)
#        at java.base/java.lang.module.Resolver.resolve(Resolver.java:192)
#        at java.base/java.lang.module.Resolver.resolve(Resolver.java:141)
