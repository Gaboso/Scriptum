@echo off
echo Executando comandos de atualizacao e instalacao do BackEnd e FrontEnd

SET caminho_script=%CD%

call git.bat

cd %caminho_script%
call maven.bat

cd %caminho_script%
call npm.bat