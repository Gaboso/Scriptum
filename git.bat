@echo off
echo Executando comandos de atualizacao GIT

cd ..\utils
call git fetch
call git pull origin 1.4

cd ..\unit
call git fetch
call git pull origin 1.3

cd ..\siga-db
call git fetch
call git pull origin 1.3

cd ..\siga-client
call git fetch
call git pull origin 1.4

cd ..\siga-api
call git fetch
call git pull origin 1.4

cd ..\hal-db
call git fetch
call git pull origin 1.3

cd ..\hal-client
call git fetch
call git pull origin 1.4

cd ..\hal-app
call git fetch
call git pull origin 1.4

cd ..\hal-api
call git fetch
call git pull origin 1.4

cd ..\comum-db
call git fetch
call git pull origin 1.3

cd ..\comum-client
call git fetch
call git pull origin 1.4

cd ..\comum-api
call git fetch
call git pull origin 1.3

cd ..\bpm-db
call git fetch
call git pull origin 1.3

cd ..\bpm-api
call git fetch
call git pull origin 1.4

cd ..\setup
call git fetch
call git pull origin 1.3

cd ..\setup-test
call git fetch
call git pull origin 1.3

cd ..\hal-jms-app
call git fetch
call git pull origin 1.3

cd ..\plano-compras-db
call git fetch
call git pull origin 1.0

cd ..\plano-compras-test
call git fetch
call git pull origin 1.0

cd ..\plano-compras-api
call git fetch
call git pull origin 1.0

cd ..\plano-compras-app
call git fetch
call git pull origin 1.0
pause