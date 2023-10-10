# EHCache Testing

[![license](https://img.shields.io/github/license/interlok-testing/testing_jsr107_cache.svg)](https://github.com/interlok-testing/testing_jsr107_cache/blob/develop/LICENSE)
[![Actions Status](https://github.com/interlok-testing/testing_jsr107_cache/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/interlok-testing/testing_jsr107_cache/actions/workflows/gradle-build.yml)

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

## Note

This config project uses [JCache Reference Implementation](https://github.com/jsr107/RI) as this is a simple example. This is not meant for production use. For that you could use one of the many open source and commercial implementations of JCache.
