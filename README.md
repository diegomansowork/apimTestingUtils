# apimTestingUtils
API Manager testing tool

API Context: /utils

This api also contains an full Items CRUD set of operations (GET,POST,PUT,DELETE)

## Echo:

```console
/echo
```

This EP could be used to check connectivity or load tests, this EP returns the an item object.


## Custom delay response:

```console
/items/1?delayInSeconds=3
```

x --> [Integer] number of delay seconds that the response will take.


## Custom response size

```console
/randomSized?size=1024
```

x --> [Integer] number of random bytes.
