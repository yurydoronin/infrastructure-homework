#!/bin/bash

set -e

echo ">> Start exec init script for db 'db_test'"

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE db_test;
EOSQL


echo ">> End exec init script for db 'db_test'"