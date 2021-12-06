(ns aoc.day06
  (:require [aoc.utils :refer :all]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn day06 []
  (let [input (->> (str/split (slurp (io/resource "day6.txt"))
                              #",")
                   (map read-string))]
    input))
