(ns clojure-caliper-example.core
  (:gen-class
   :name clojure-caliper-example.core.MyBenchmark
   :methods [[timeFibNaive [int] void]
             [timeFib [int] void]]
   :extends com.google.caliper.SimpleBenchmark)
  (:import (com.google.caliper SimpleBenchmark)))

(defn fib
  ([n] (fib [0 1] n))
  ([s n] (if (> n (count s))
           (fib (conj s (apply + (take-last 2 s))) n)
           s)))

(defn fib-naive
  [n]
  (cond
    (= n 1) 0
    (= n 2) 1
    :else (+ (fib-naive (- n 1)) (fib-naive (- n 2)))))

(defn -timeFib
  [this reps]
  (dotimes [n reps] (fib 30)))

(defn -timeFibNaive
  [this reps]
  (dotimes [n reps] (fib-naive 30)))



;; API to built in caliper clojure binding
;;
;; (measure fn1 fn2 fn3 ...)
;;
;; todo this I can create one subclass of SimpleBenchmark defines 1 function to
;; time and create multiple proxies each measuring one of the function
;;
;; (compare fn1 fn2)
;;
;; todo this I can create a simple benchmark inherited class defining 2
;; functions which get compared
;;
