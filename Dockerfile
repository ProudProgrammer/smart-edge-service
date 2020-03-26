FROM openjdk:11
EXPOSE 8080
ENV DIRPATH /smart/share/edge
COPY release/target/edge-service-release-1.0-SNAPSHOT.jar $DIRPATH/edge-service.jar
COPY init.sh /smart/share/init.sh
RUN chmod 755 /smart/share/init.sh
WORKDIR $DIRPATH
ENTRYPOINT ["/smart/share/init.sh"]