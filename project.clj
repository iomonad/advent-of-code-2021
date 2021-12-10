(defproject aoc "0.1.0-SNAPSHOT"
  :description "Advent Of Code 2021"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure                      "1.10.1"]
                 [cheshire                                 "5.10.1"]
                 [com.rpl/specter                          "1.1.3"]
                 [net.mikera/vectorz-clj                   "0.48.0"]
                 [net.mikera/core.matrix                   "0.62.0"]
                 [criterium                                "0.4.6"]
                 [org.clojure/core.async                   "1.5.644"]
                 [com.clojure-goes-fast/clj-async-profiler "0.1.0"]]
  :repl-options {:init-ns aoc.core})
