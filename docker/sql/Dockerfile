FROM mysql:8.0

# Environment variables
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE voting_app

ADD init_db.sh /tmp/init_db.sh
RUN /tmp/init_db.sh

ADD dump.sql /docker-entrypoint-initdb.d

EXPOSE 3307
