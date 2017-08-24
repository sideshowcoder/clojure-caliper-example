(ns clojure-caliper-example.runner
  (:require [clojure-caliper-example.core]
            [clojure.data.json :as json]
            [clojure.java.io :as io])
  (:import (clojure-caliper-example.core MyBenchmark)
           (com.google.caliper Runner))
  (:gen-class))

(defn run
  "Runs a Caliper Benchmark class using the caliper runner. The
  results are printed to stdout, in cider this is the *nrepl-server
  xyz* buffer, and are returned as a map."
  [benchmark]
  (let [runner (Runner.)
        result-file (java.io.File/createTempFile "results" ".json")
        result-file-path (.getAbsolutePath result-file)
        benchmark-name (.getName benchmark)
        runner-args (into-array String ["--saveResults" result-file-path benchmark-name])]
    (try
      (.run runner runner-args)
      (with-open [result-json (io/reader result-file-path)]
        (json/read-json result-json))
      (finally (io/delete-file result-file true)))))

(defn -main
  [& args]
  (run MyBenchmark))

