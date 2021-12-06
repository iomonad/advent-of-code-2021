(ns aoc.day05
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]))

(defn day05 []
  (letfn [(parse-line [l]
            (->> (str/split l #" -> ")
                 (map #(str/split % #","))
                 (mapv (partial mapv read-string))))]
    (let [input (read-input "day5.txt" :alter-fn parse-line)]
      input)))
