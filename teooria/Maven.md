# Installing Maven

1. Download Binary zip archive for Maven
2. Extract it to a directory
3. Add apache-maven\bin to PATH
4. check if mvn -v works



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


# Commands

mvn -v              Checks the installed Maven version
mvn validate        Checks if the project is valid: no broken files, etc



mvn clean           Delete target folder
mvn compile