echo building app: mvn package
mvn package -q
echo Running app with the following command:
echo java -jar target/rovers-0.0.1-SNAPSHOT.jar input.txt
java -jar target/rovers-0.0.1-SNAPSHOT.jar input.txt
