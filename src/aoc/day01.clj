(ns aoc.day01
  (:require [clojure.java.io :as io]
            [com.rpl.specter :as sp]
            [aoc.utils :refer :all]))

(defn result1-naive []
  (let [input (read-input "day1.txt"
                          :alter-fn read-string)
        state (atom 0)]
    (doseq [c (range (count input))
            :let [current (nth input c)]]
      (if-let [right (nth input (inc c) nil)]
        (if (< right current)
          (swap! state inc))))
    (dec (- (count input) @state))))


(defn day01 []
  (let [input (read-input "day1.txt"
                          :alter-fn read-string)]
    (->> (partition 2 1 input)
         (map (fn [[a b]] (> a b)))
         (filter true?)
         count)))
