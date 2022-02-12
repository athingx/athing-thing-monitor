#!/bin/bash

projects[i++]="io.github.athingx.athing.thing.monitor:thing-monitor"
projects[i++]="io.github.athingx.athing.thing.monitor:thing-monitor-general"

mvn clean install \
  -f ../pom.xml \
  -pl "$(printf "%s," "${projects[@]}")" -am \
  '-Dmaven.test.skip=true'
