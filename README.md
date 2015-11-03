# React / Clojure / Postgres Template

This template implements a technology stack intended to bootstrap rapid
development of a web application or web service based on React, Clojure
and Postgres.

The resulting deployable artifact is a standalone executable JAR file which
contains the complete web application, including all web resources embedded
within it.

## Prerequisites

* Java 1.8+
* Leiningen 2.5.2+
* Node 0.12.7+
* Postgres 9.3+
* MyBatis Migrations

## Usage

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


## License

TODO
