rem building app: mvn package
mvn package -q
rem Running app with the following command:
rem java -jar target/rovers-0.0.1-SNAPSHOT.jar input.txt
java -jar target/rovers-0.0.1-SNAPSHOT.jar input.txt
