@echo off
cd ..
start javaw -Xmx2048M -Xms2048M -classpath ./plugins/*.jar;./lib/*.jar;./bin -jar ./lib/battlerpg-main-module.jar
cd bin
