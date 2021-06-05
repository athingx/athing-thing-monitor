#!/bin/bash

projects[i++]="com.github.athingx.athing.aliyun.monitor:monitor-component"

mvn clean install \
  -f ../pom.xml \
  -pl "$(printf "%s," "${projects[@]}")" -am \
  '-Dmaven.test.skip=true'
