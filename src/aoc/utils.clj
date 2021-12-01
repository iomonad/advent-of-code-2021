(ns aoc.utils
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))


(defn read-input
  [asset & {:keys [alter-fn]
            :or {alter-fn identity}}]
  (some->> (io/resource asset)
           slurp
           str/split-lines
           (map alter-fn)))
