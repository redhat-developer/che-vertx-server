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

## Usage with che-starter
To use this mocked Vert.x server with che-starter, use following values for parameters in che-starter REST API:
- `masterUrl` - when running locally, use `http://localhost:33333`, otherwise use real endpoint of the deployment of this server (e.g. on OpenShift a route URL)
- `namespace` - use `eclipse-che`, for now it reflects real OpenShift project of Che server deployment
- `Authorization` - use any string, there is no limitation so far
- `param` - when creating a new workspace, use following params in case you wish successful calls 
``` javascript
 {
  "branch": "master",
  "description": "https://github.com/mlabuda/vertx-with-che.git#master",
  "id": "chevertxwsid13",
  "name": "vertxworkspace",
  "repo": "https://github.com/mlabuda/vertx-with-che",
  "stack": "vert.x"
}
```