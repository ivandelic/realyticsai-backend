FROM maven:3.5.4-jdk-9 as build
WORKDIR /realyticsai
ADD pom.xml .
ADD realiticsai-common realiticsai-common
ADD realiticsai-lgu-manager realiticsai-lgu-manager
ADD realiticsai-lgu-manager-dev realiticsai-lgu-manager-dev
ADD realiticsai-lgu-manager-test realiticsai-lgu-manager-test
RUN mvn package -DskipTests
RUN echo "Maven package done!"

FROM eu-frankfurt-1.ocir.io/oraseemeaceeociworkshop/ivandelic/realyticsai/realyticsai-base-image:latest
WORKDIR /realyticsai
ENV TNS_ADMIN="/wallet"
ENV JAVAX_SQL_DATASOURCE_LGU_dash_MANAGER_dash_ORCL_dash_DS_DATASOURCE_USER=""
ENV JAVAX_SQL_DATASOURCE_LGU_dash_MANAGER_dash_ORCL_dash_DS_DATASOURCE_PASSWORD=""
COPY --from=build /realyticsai/realiticsai-lgu-manager-test/target/realiticsai-lgu-manager-test.jar ./
COPY --from=build /realyticsai/realiticsai-lgu-manager-test/target/libs ./libs
CMD ["java", "-jar", "realiticsai-lgu-manager-test.jar"]
EXPOSE 8080