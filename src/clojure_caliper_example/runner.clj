(ns clojure-caliper-example.runner
  (:require [clojure-caliper-example.core])
  (:import (clojure-caliper-example.core MyBenchmark)
           (com.google.caliper Runner))
  (:gen-class))

(defn -main
  [& args]
  (let [runner (Runner.)
        benchmark (into-array String [(.getName MyBenchmark)])]
    (.run runner benchmark)))
