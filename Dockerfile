FROM jboss/base-jdk:8

USER root
RUN mkdir -p /userdata

EXPOSE 33333

RUN chown -R jboss /userdata \
 && usermod -g root -G `id -g jboss` jboss \
 && chmod -R "g+rwX" /userdata \
 && chown -R jboss:root /userdata

USER jboss

RUN git clone https://github.com/mlabuda/che-vertx-server.git && \
    cd che-vertx-server && \
    mvn clean install

CMD ["java", "-jar", "/userdata/che-vertx-server/target/vertx-server.jar"]