@echo off
cd ..
java -Xmx2048M -Xms2048M -classpath ./plugins/%1;./lib/battlerpg-main-module.jar;./bin -jar ./lib/battlerpg-main-module.jar -p %2
cd bin
