@echo off
echo Executando comandos de instalacao do Maven

cd ..\utils
call mvn clean install -DskipTests=true

cd ..\unit
call mvn clean install -DskipTests=true

cd ..\comum-db
call mvn clean install -DskipTests=true

cd ..\comum-api
call mvn clean install -DskipTests=true

cd ..\comum-client
call mvn clean install -DskipTests=true

cd ..\siga-db
call mvn clean install -DskipTests=true

cd ..\siga-api
call mvn clean install -DskipTests=true

cd ..\siga-client
call mvn clean install -DskipTests=true

cd ..\bpm-db
call mvn clean install -DskipTests=true

cd ..\bpm-api
call mvn clean install -DskipTests=true

cd ..\hal-db
call mvn clean install -DskipTests=true

cd ..\hal-api
call mvn clean install -DskipTests=true

cd ..\hal-client
call mvn clean install -DskipTests=true

cd ..\hal-app
call mvn clean install -DskipTests=true

cd ..\plano-compras-db
call mvn clean install -DskipTests=true

cd ..\plano-compras-api
call mvn clean install -DskipTests=true

cd ..\plano-compras-app
call mvn clean install -DskipTests=true
pause