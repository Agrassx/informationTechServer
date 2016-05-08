# API server for android application "InformationTech"


## Requirements

* Play Framework 2.5.x
* MySQL Server or another DataBase


## Routing
```
/               - some leaflat app (it might be web-version)
/api/v1/list    - retrieving article list

```
  GET args:
  * offset - version of article list

## DataBase

To work needed MySQL DataBase (or another) with table:

```
    +---------------------------+
    |         Articles          |
    +---------------------------+
    | offset (auto increment)   |
    | name                      |
    | url                       |
    +---------------------------+

```

And DataBase handler with the following methods:

   * putArticle(Article article) - insert new article
   * getUpdates() - get JsonArray of article list
   * getLastOffset() - get last offset version from DataBase

## What does server do?

```
                                           +--------+
GET                                        |        |
        /api/v1/list?offset=...         -> |        |
                                           | Server |
        [ { JSON Response } ]           <- |        |
                                           |        |
                                           +--------+
```

## Where Json Response:

* Example Json response for adding article into list of android app

```

{
    "result": "ok",
    "offset": $offset,
    "articleList": [
            {
                "name": $name,        //name of article
                "url": $url          //url path to article
            }, ...
        ]
}

```

* Example Json response for delete article from list of android app

```
{
    "result": "ok",
    "offset": $offset,
    "articleList": [
            {
                "name": $name,      //name of article
                "url": ""           //empty
            }, ...
        ]
}

```

# Default Play Framework's Documentation

## Controllers

* HomeController.java:

  Shows how to handle simple HTTP requests.

* AsyncController.java:

  Shows how to do asynchronous programming when handling a request.

* CountController.java:

  Shows how to inject a component into a controller and use the component when
  handling requests.

## Components

* Module.java:

  Shows how to use Guice to bind all the components needed by your application.

* Counter.java:

  An example of a component that contains state, in this case a simple counter.

* ApplicationTimer.java:

  An example of a component that starts when the application starts and stops
  when the application stops.

## Filters

* Filters.java:

  Creates the list of HTTP filters used by your application.

* ExampleFilter.java

  A simple filter that adds a header to every response.