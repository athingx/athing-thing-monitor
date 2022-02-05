#!/bin/bash

projects[i++]="io.github.athingx.athing.aliyun.monitor:monitor-thing"
projects[i++]="io.github.athingx.athing.aliyun.monitor:monitor-thing-impl"

mvn clean install \
  -f ../pom.xml \
  -pl "$(printf "%s," "${projects[@]}")" -am \
  '-Dmaven.test.skip=true'
