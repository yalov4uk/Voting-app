FROM mysql:5

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE voting_app
ENV MYSQL_USER root
ENV MYSQL_PASSWORD root

ADD dump.sql /tmp/dump.sql
ADD init_db.sh /tmp/init_db.sh
RUN ["chmod", "+x", "/tmp/init_db.sh"]

