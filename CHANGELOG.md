# Changelog

All notable changes to this project will be documented in this file.

## [3.0.0] - 2023-02-15

### Changed
- Update log4j dependency from 2.18.0 to 2.19.0
- Update maven-assembly-plugin dependency from 3.4.1 to 3.4.2
- Improve logger logic in ModuleRunner
- Renamed class from CommandHelper to CommandExecutor

### Added

- Unit tests and unit tests dependencies: JUnit and mockito
- Created ModuleTypeEnum to store module name and commands
- Created OpSystemEnum to store OS runner and option

### Removed

- Formatter class
- OsHelper class

## [2.0.0] - 2022-07-05

### Changed

- Update log4j dependency from 2.17.2 to 2.18.0
- Update maven-assembly-plugin dependency from 3.3.0 to 3.4.0
- Split Scriptum class in other two classes
- Change jar entry point from Scriptum class to Main class
- Change Modules to implements Module interface
- Update maven build final name, to use name and version


## [1.4.1] - 2022-04-24

### Changed

- Update log4j dependency
- Add Javadoc in some classes
- Clean up some code
- Update maven build final name, to use name and version

## [1.4.0] - 2021-10-12

### Changed

- Update modules logic to prevent NPE

## [1.3.7] - 2020-08-09

### Changed

- Changelog changed to English.

## [1.3.6] - 2020-08-09

### Changed

- Version updated Log4j.

## [1.3.5] - 2020-08-09

### Changed

- Updated the way the log was generated.
- Fixed typos in the changelog.

## [1.3.4] - 2018-05-28

### Added

- Project license

### Changed

- Internal structure of packages.

## [1.3.3] - 2018-01-20

### Added

- Function of starting the jar without passing a workspace parameter.
- FileHelper class, to assist actions involving files.
- OsHelper class, to assist actions involving OS properties.

### Changed

- Internal structure of packages.
- Changelog structure of the project.

## [1.3.2] - 2018-01-18

### Changed

- Internal fixes and improvements in addition to code cleaning.

## [1.3.1] - 2017-12-20

### Added

- Linux support.

## [1.2] - 2017-07-12

### Added

- Module for projects that use Grunt.

### Changed

- Correction in the way the log is generated.

## [1.1] - 2017-04-30

### Changed

- Correction to the internal links present in the README.
- Modified build process to run with `mvn install`.
- Changed the final name of the jar to the name of `artifactId` being reduced to` scriptum.jar`
- Adjust the examples in README.md to suit the new jar name.

## [1.0] - 2017-04-30

### Added

- Git update module
- Maven installation module
- Npm update module
- Bower update module
