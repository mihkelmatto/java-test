# Installing Maven

1. Download Binary zip archive for Maven
2. Extract it to a directory
3. Add apache-maven\bin to PATH
4. check if mvn -v works (checks the installed version)


## useful links
JavaFX                      https://openjfx.io/openjfx-docs/maven
Maven dependency search     search.maven.org

## Maven wrapper
Wraps a project with a specific version of maven, 
which means you can use Maven on this project, without having it installed

installing the wrapper: use this cmd at the project root
mvn wrapper:wrapper

You can now use maven commands with ./mvnw
ex: ./mvnw -v



# Maven intro
Maven is a tool for managing a project, its dependencies and transitive dependencies
- automatically downloads the project's dependencies (libraries)
- manages tasks in the build lifecycle (test, compile, build, ...)
- manages project file structure
- uses a central repository for downloads (maven central repository)
- can use plugins to extend its functionality



# Build lifecycle

validate -> compile -> test -> package -> verify -> install -> deploy
- every step's command also runs previous steps
- clean keyword resets the lifecycle and deletes target folder. ex: mvn clean install


- mvn validate      check project structure and dependencies (pom.xml)
- mvn compile       .java -> .class // outputs to target/classes
- mvn test          running tests (needs to be configured)
- mvn package       package the project to .jar or .war // outputs to target/*.jar
- mvn verify        additional tests and verification (needs to be configured)
- mvn install       install a packaged project to local mvn repo
- mvn deploy        deploy a packaged project to remote repo



# standard file structure
src/
  main/
    java/
    resources/
  test/
    java/
    resources/



# pom.xml file
This file is used to configure and validate the project

## Project ID for maven repos
Their combination has to be unique in the relevant scope (Local or server):
- groupId       organization, domain (ex: com.company)
- artifactId    project name (ex: user-service)
- version       project version (ex: 1.0.0)

## build config
Configurations for build command

<build>
  <finalName>my-app</finalName>       sets the name for output jar file: my-app.jar
  ...
</build>

## plugins
Plugins are used for additional functionality for maven
to install a plugin, paste its instructions to plugins -> ...

Some important plugins:
- maven compiler plugin

plugin hierarchy in pom.xml:
- build -> plugins -> plugin

## properties
Settings for maven or its plugins
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> // encoding for build
    <maven.compiler.source>11</maven.compiler.source> // specifies java version for compiler
    <maven.compiler.target>11</maven.compiler.target>
</properties>

## inheritance
Has a separate block in pom.xml to define parent/child relationships between pom.xml files
Can be used for:
- reusing pom.xml settings between separate projects
- multi-module projects (project-in-project)

child will inherit everything from its parent
exceptions:
- partial for versions
- no dependencies
- no artifactid