FROM liquibase/liquibase:4.4

ENV DATABASE_HOST=localhost
ENV DATABASE_PORT=5432
ENV DATABASE_NAME=db_test
ENV DATABASE_SCHEMA=public
ENV DATABASE_USERNAME=postgres
ENV DATABASE_PASSWORD=12345

COPY src/main/resources /liquibase/changelog
WORKDIR /liquibase/changelog

CMD ["sh", "-c", "docker-entrypoint.sh \
--url=\"jdbc:postgresql://${DATABASE_HOST}:${DATABASE_PORT}/${DATABASE_NAME}?currentSchema=${DATABASE_SCHEMA}\" \
--username=${DATABASE_USERNAME} \
--password=${DATABASE_PASSWORD} \
--classpath=/liquibase/changelog \
--logLevel=info \
--changeLogFile=db-migrations/main.xml update"]