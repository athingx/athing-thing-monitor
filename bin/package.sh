#!/bin/bash

projects[i++]="com.github.athingx.athing.aliyun.monitor:monitor-boot"

# maven package boot projects
mvn clean package \
  -f ../pom.xml \
  -pl "$(printf "%s," "${projects[@]}")" -am \
  '-Dmaven.test.skip=true'