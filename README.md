# EHCache Testing

Project tests interlok-jsr107-cache features

## What it does

This project contains a single Interlok instance that allows you to store and retrieve values.

We have three workflows, the first requires you to HTTP POST some content, the second workflow allows you to GET that content back from the cache and finally the third allows you to remove data from the cache.

Simply POST some content to the following;
 - http://localhost:8080/input?key=myChosenKey

Notice the __key__ parameter in the URL; the value of which will be the cache key we'll use to retrieve the same content, allowing you to store multiple payloads against different key values.

Now fire a GET request against the following URL;
 - http://localhost:8080/recall?key=myChosenKey

Finally fire a POST/GET request against the following URL;
 - http://localhost:8080/remove?key=myChosenKey

![ehcache diagram](/ehcache.png "ehcache diagram")
 
## Getting started

* `./gradlew clean build`
* `(cd ./build/distribution && java -jar lib/interlok-boot.jar)`

