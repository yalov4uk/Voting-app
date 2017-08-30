#!/bin/bash
/usr/bin/mysqld_safe &
sleep 5
mysql -u root -e "CREATE DATABASE voting_app"
mysql -u root voting_app < /tmp/dump.sql
