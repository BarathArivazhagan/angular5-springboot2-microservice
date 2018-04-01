# angular5-springboot2-microservice

1. spring-boot-2 microservice
2. angular-5-application

# Steps to build and deploy the application 

* clone the repository 

```
$ git clone https://github.com/BarathArivazhagan/angular5-springboot2-microservice.git
```

* Build inventory-reactive-app

```
$ cd inventory-reactive-app
$ ./mvnw clean install -DskipTests
```

* Deploy inventory-reactive-app

```
$ cf push
```

* Build angular5-inventory-app

```
$ cd angular5-inventory-app
$ npm run dist
```

* Deploy angular5-inventory-app

```
$ cd dist
$ cf push
```




