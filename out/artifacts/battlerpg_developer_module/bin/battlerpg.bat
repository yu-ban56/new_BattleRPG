@echo off
cd ..
start javaw -Xmx2048M -Xms2048M -classpath ./plugins/*.jar;./lib/*.jar;./bin battlerpg.main.Main

