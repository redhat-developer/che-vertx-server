# Vert.x server for che-starter performance testing
Vert.x server runs locally by default on `localhost:33333`.

## How to run locally
- build project `mvn clean package` and run fat jar `java -jar target/vertx-server.jar`

## How to run on OpenShift
- there is a docker image `mlabuda/che-vertx-server:openshift` on dockerhub which is ready to run on OpenShift, or on docker locally
- required parameters for running on OpenShift are `VERTX_CHE_SERVER_URL`, `VERTX_OS_ROUTE_HOST`

## Run parameters
There are several execution parameters:
- `VERTX_CHE_SERVER_URL` - URL of virtual Che server (this vertx server), default `http://localhost:33333`
- `VERTX_OS_ROUTE_HOST` - OpenShift route host of Che server, default value is set to this vert.x server running locally, value can't contain http prefix, default `localhost:33333`. 
- `VERTX_DC` - deployment config name of Che server deployment on OpenShift, default `che`
- `VERTX_OS_ROUTE_NAME` - OpenShift route name of Che server, default `che-host`