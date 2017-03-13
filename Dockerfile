FROM jboss/base-jdk:8

ENV VERTICLE_FILE vertx-server.jar

ENV VERTICLE_HOME /opt/jboss
ENV vertx.cacheDirBase $VERTICLE_HOME

EXPOSE 33333
  
COPY target/$VERTICLE_FILE $VERTICLE_HOME/

USER root

RUN chgrp -R 0 $VERTICLE_HOME \
  && chmod -R g+rwX $VERTICLE_HOME

USER jboss

WORKDIR $VERTICLE_HOME

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $VERTICLE_FILE"]