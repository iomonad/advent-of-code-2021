(ns aoc.day07
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn day07 []
  (let [input (->> (str/split (slurp (io/resource "day6.txt"))
                              #",")
                   (map read-string))]
    input))
