# Scriptum [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Installer and updater dependencies for: _Git_, _Maven_, _Grunt_, _npm_ e _bower_ 

-----

## How to build

Run the __`build.bat`__ file for _Windows_ or __`build.sh`__ for _Linux_, both are in the root directory of this project

> After execution, the file __`scriptum.jar`__ will be generated in the directory `target`
  
## How to use

[Download latest version](https://github.com/Gaboso/Scriptum/releases/latest "latest version") or [Build jar](#how-to-build "build project")

There are two ways to run:
* Pass the workspace path as a parameter:
    * Examples:     
            __`java -jar scriptum.jar [workspace path]`__
            __`java -jar scriptum.jar /home/workspace`__
* Do not pass the parameter, then Scriptum will use as workspace path the directory where __`scriptum.jar`__ is:
    * Example: __`java -jar scriptum.jar`__
