(defproject clojure-caliper-example "0.1.0-SNAPSHOT"
  :description "clojure-caliper-example"
  :url "https://github.com/sideshowcoder/clojure-caliper-example"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clojure-caliper-example.runner
  :aot :all
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.google.caliper/caliper "0.5-rc1"]])
