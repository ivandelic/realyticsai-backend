FROM maven:3.5.4-jdk-9 as build
WORKDIR /tesla
ADD pom.xml .
ADD tesla-common tesla-common
ADD tesla-powerplant-registry tesla-powerplant-registry
ADD tesla-powerplant-registry-dev tesla-powerplant-registry-dev
ADD tesla-powerplant-registry-test tesla-powerplant-registry-test
RUN mvn package -DskipTests
RUN echo "Maven package done!"

FROM eu-frankfurt-1.ocir.io/oraseemeaceeociworkshop/ivandelic/hep/tesla-base-image:latest
WORKDIR /tesla
ENV TNS_ADMIN="/wallet"
ENV JAVAX_SQL_DATASOURCE_TESLA_dash_POWERPLANT_dash_REGISTRY_dash_ORCL_dash_DS_DATASOURCE_USER=""
ENV JAVAX_SQL_DATASOURCE_TESLA_dash_POWERPLANT_dash_REGISTRY_dash_ORCL_dash_DS_DATASOURCE_PASSWORD=""
COPY --from=build /tesla/tesla-powerplant-registry-dev/target/tesla-powerplant-registry-dev.jar ./
COPY --from=build /tesla/tesla-powerplant-registry-dev/target/libs ./libs
CMD ["java", "-jar", "tesla-powerplant-registry-dev.jar"]
EXPOSE 8080