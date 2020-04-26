# Spring Boot Micro Service With Keycloak 
> This is spring boot micro service keycloak rest endpoint security example.
![Spring Boot Micro Service With Keycloak](https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRMdem6yM0C2u_YWSqf2xbULvwu3EAmMSxyWU2LKyfbOtH8BQDg&usqp=CAU)
## Prerequisites

* Jdk 1.8
* Maven 3.x
* Docker 19.03.x
* Docker Compose 1.25.x

## Installation
```sh
sudo bash -c 'cat << EOF >> /etc/hosts
127.0.0.1 keycloak
EOF'
```

```sh
sudo chmod +x build.sh
```
```sh
./build.sh
```

```sh
docker-compose up -d
```

## Notes

> Keycloak access must be 'keycloak' instead of localhost for token request

## Used Technologies

* Spring Boot 2.2.6
* Spring Cloud Hoxton.SR3
* Spring Cloud Eureka Server
* Spring Cloud Zuul Gateway
* Keycloak
* Mysql
* Elasticsearch
* Kibana


