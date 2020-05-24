# Project is work in progress

# Description
An unofficial party planner for the game series Etrian Odyssey

# Build locally
- Java 8
- PostgeSQL 12.1
- Rename `hikari.properties.template` to `hikari.properties` and fill it out with the information for the database connection
- Run `gradlew.bat run` in the backend folder to build and start the backend api. Visit the page under localhost:8090
- Run `gradlew.bat shadowJar` in the backend folder to create a jar of the backend.
- Run `npm run serve` in the frontend folder to start the frontend. Visit the page under localhost:8081
