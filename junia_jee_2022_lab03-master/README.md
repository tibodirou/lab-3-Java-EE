# Lab 03

## Intro
Several goals for this homework:
* You will become a master of JPA annotations
* JPA for Spring won't have secrets for you anymore
* Spring Data JPA magic
* Handle a layered conception

We will print, in a web page, the content of a DB.

## DB Initialization
* Create a new schema named `junia_lab03`
* We assume that your DB credentials are `root:root`

## TODO's
Just read the provided code and replace the TODO's with your implementation.

## How to test your project?
You have 2 modules:
* `lab03-data` will help you to populate your DB. If your implementation is correct, launch the main method of that module and you will find in your DB the created tables with data inside.
* `lab03-web` is a small webapp which calls automatically your core services.

## Tip
Even if the course refers to `CrudRepository`, take a look at `JpaRepository` which is more powerful.