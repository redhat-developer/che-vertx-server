# Vert.x server for che-starter performance testing
Vert.x server runs on localhost:33333

## How to run
- build project `mvn clean package`
- run fat jar `java -jar target/che-vertx-server-0.0.1-SNAPSHOT-fat.jar`

## Run parameters

There are several execution parameters if the environment is different than the assumed default one.
- `openshiftRouteName` - OpenShift route name where Che server is accessible, default `che-host`
- `openshiftRouteHost` - OpenShift route host of Che server, default value is set to this vert.x server running locally `localhost:33333`
- `openshiftProject` - OpenShift project in which Che server is running, default `online-tennant`
