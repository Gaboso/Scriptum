@echo off
echo Executando comandos de atualizacao Node, Bower e Grunt

SET caminho=%CD%

cd ..\setup
call %caminho%\npm_cmds.bat

cd ..\auto-cadastro
call %caminho%\npm_cmds.bat

cd ..\setup-test
call %caminho%\npm_cmds.bat

cd ..\plano-compras
call %caminho%\npm_cmds.bat

cd ..\plano-compras-test
call %caminho%\npm_cmds.bat
pause