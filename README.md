# clojure-caliper-example

Using [Caliper (0.5-rc1](https://github.com/google/caliper/tree/v0.5-rc1) from
clojure for microbenchmarking.

The important files to look at are `core.clj` defining a benchmark by extending
`SimpleBenchmark` and `runner.clj` using the calipers `Runner` class to run the
benchmark defined.

`project.clj` furthermore defines the usage of AOT, to make gen-class work as
expected.

## Usage

```
lein run
```

## Resources

- [Microbenchmarking with Caliper](http://codingjunkie.net/micro-benchmarking-with-caliper/)
- [Caliper Source](https://github.com/google/caliper/tree/v0.5-rc1)
- [Example of using Caliper](https://gist.github.com/codahale/5304067)

## License

Copyright © 2017 Philipp Fehre

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
