mvn clean install
cd product-service
sleep 10
mvn dockerfile:build
cd ../
cd eureka-server
sleep 10
mvn dockerfile:build
cd ../
cd zuul-server
sleep 10
mvn dockerfile:build
cd ../