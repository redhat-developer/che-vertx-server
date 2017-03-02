# Vert.x server for che-starter performance testing
Vert.x server runs by default on `localhost:33333`

## How to run
- build project `mvn clean package`
- run fat jar `java -jar target/che-vertx-server-0.0.1-SNAPSHOT-fat.jar`

## Run parameters

There are several execution parameters:
- `cheServerURL` - URL of virtual Che server (this vertx server), default `http://localhost:33333`
- `openshiftDeploymentConfig` - deployment config name of Che server deployment on OpenShift, default `che`
- `openshiftRouteName` - OpenShift route name of Che server, default `che`
- `openshiftRouteHost` - OpenShift route host of Che server, default value is set to this vert.x server running locally, value can't contain http prefix, default `localhost:33333`. 
- `openshiftProject` - OpenShift project in which Che server is running, default `che`
- `workspaceId` - id of Che workspace, default `chevertxwsid13`
- `workspaceName`- name of Che worksace, default `vertx-with-che`
- `stackId` - id of stack in Che, default `default-vertx-stack`
- `stackName` - name of stack in Che, default `vertx_stack`
