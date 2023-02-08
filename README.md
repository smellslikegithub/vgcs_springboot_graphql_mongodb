
# VGCS Solution Attempt For BE

This solution tries to attempt the tasks given for the BE development. For this project to run on your machine you need to have some pre-requisites installed and configured in your machine.




## Installation and Usage

### Mockoon and Dummy API

First of all, download the mockoon client and upload the sample VGCS-COSTA-assignment-mock to the mokoon client and start serving the mocked API. You can download the client from the following site:

```bash
 https://mockoon.com/download/

 For the purposes of this app, serve the mocked API using mokoon at this url 
 http://localhost:1337/vehicle
```

### Docker, mongodb and mongoexpress

Next, install docker in your machine. Since I have used windows, you can install docker for windows. We need this to spin up the mongodb and mongoexpress services. Mongodb will hold the data we collect from the mocked API while mongoexpress gives us a better way to visualize the data. 

Once docker is installed, from the root directory of the project run the following file \vehicle\docker-compose.yaml

```bash
docker-compose up --build
```

Once the mongo is up and running, go to mongo express and create an empty database called:

```bash
vehicles
http://localhost:8081/
```

### Spin up the spring boot app
Use your favorite IDE to run the Spring-boot app. The app should automatically http://localhost:8080

### Seed data to mongodb

Now, we must take all the data from the mock API and store it in mongodb. To do that, use the seed_vehicle endpoint.

```bash
http://localhost:8080/seed_vehicles
```
The response should be all vehicle data, which would be stored in the db.

The data will be persisted untill the docker-compose down is performed.

### Graphql
The spring boot app is preconfigured to expose the graphiql web interface to interact with the graph ql queries. The queries come with their own documentations. For the purposes of this setup, follow the link once the spring-boot app is running.

```bash
http://localhost:8080/graphiql?path=/graphql
```
The schema and sample queries can be found here in vehicle\src\main\resources\graphql\

I have tried to do graphql queries for all three use cases as described in the slide.
