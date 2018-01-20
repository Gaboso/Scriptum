# Scriptum

Projeto para facilitar a manutenção de ambientes que utilizem: _Git_, _Maven_, _Grunt_, _npm_ e _bower_ 

-----

## Índice de conteúdo

* [Como Utilizar](#como-utilizar "Como utilizar")
* [Notas de release](#notas-de-release "Notas de release do projeto")
* [Issues](#issues "Issues do projeto")

-----

## Como utilizar

__1° passo__: Execute o arquivo __`build.bat`__ para (_Windows_) ou o __`build.sh`__ para (_Linux_), presente no diretorio raiz deste projeto



__2° passo__: Após a execução do primeiro passo, sera gerado o arquivo __`scriptum.jar`__ no diretorio
`target`, há duas maneiras de execução:
 * Passar como paramêtro o caminho do workspace: __`java -jar scriptum.jar [caminho do workspace]`__.
   * Exemplo do comando: __`java -jar scriptum.jar C:\workspace`__
 * Não passar o paramêtro que o Scriptum irá utilizar como workspace o diretorio onde o __`scriptum.jar`__ estiver: __`java -jar scriptum.jar`__.
   * Exemplo do comando: __`java -jar scriptum.jar`__




-----

## Notas de release

Para visualizar as notas de release acesse o _link_ abaixo:

[Notas de release](CHANGELOG.md)

-----

## Issues

Veja os issues do projeto: [aqui](../../issues)
