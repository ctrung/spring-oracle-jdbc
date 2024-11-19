Playground pour jouer avec JDBC et Oracle

## Installer Oracle

docker run -d -p 1521:1521 -e ORACLE_PASSWORD=\<password> gvenzl/oracle-free

Registry officiel : https://hub.docker.com/r/gvenzl/oracle-free \
(Oracle Free remplace Oracle XE)

## Créer un user

Exécuter le script suivant avec SYSTEM.

```sql
CREATE USER <myuser> IDENTIFIED BY <password>;
GRANT CONNECT TO <myuser>;
GRANT CREATE SESSION TO <myuser>;
GRANT CREATE TABLE TO <myuser>;
GRANT UNLIMITED TABLESPACE TO <myuser>;
```

## Créer une table

```sql
CREATE SEQUENCE logging_event_id_seq MINVALUE 1 START WITH 1;

CREATE TABLE logging_event
(
    timestmp         NUMBER(20) NOT NULL,
    formatted_message  VARCHAR2(4000) NOT NULL,
    logger_name       VARCHAR(254) NOT NULL,
    level_string      VARCHAR(254) NOT NULL,
    thread_name       VARCHAR(254),
    reference_flag    SMALLINT,
    arg0              VARCHAR(254),
    arg1              VARCHAR(254),
    arg2              VARCHAR(254),
    arg3              VARCHAR(254),
    caller_filename   VARCHAR(254) NOT NULL,
    caller_class      VARCHAR(254) NOT NULL,
    caller_method     VARCHAR(254) NOT NULL,
    caller_line       CHAR(4) NOT NULL,
    event_id          NUMBER(10) PRIMARY KEY
);
```

## Insérer une ligne

```shell
curl --location --request POST 'http://localhost:8080/logs' \
--header 'Content-Type: application/json' \
--data-raw '{
    "loggerName": "toto",
    "formattedMessage": "hello world"
}'
```