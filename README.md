# React / Clojure / Postgres Template

This template implements a technology stack intended to bootstrap rapid
development of a web application or web service based on React, Clojure
and Postgres.

The resulting deployable artifact is a standalone executable JAR file which
contains the complete single-page web application, including all web resources 
embedded within it.

## Features

* React 0.14.0
  * React-Router
  * React-Bootstrap
* Clojure 1.7.0
  * Ring
  * Compojure
  * Cheshire

## Prerequisites

* Java 1.8+
* Leiningen 2.5.2+
* Node 0.12.7+
* Postgres 9.3+
* MyBatis Migrations 
    - https://github.com/mybatis/migrations/releases/tag/mybatis-migrations-3.2.0

## Usage

### Create the database

```
cd {clone_dir}/database
psql -U {dba_username} -f create_database.sql
migrate up

```

### Run in development mode:

```
cd {clone_dir}/web
npm install
npm run-script watch

cd {clone_dir}
lein ring server-headless
```

### Build for deployment:

```
cd {clone_dir}/web
npm run-script build

cd {clone_dir}
lein ring uberjar

java -jar target/{jarfile}.jar
```

