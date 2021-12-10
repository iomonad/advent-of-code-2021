(ns aoc.day09
  (:require [aoc.utils :refer :all]))

(defn day09 []
  (->> (read-input "day9.txt")
       (map count)))
