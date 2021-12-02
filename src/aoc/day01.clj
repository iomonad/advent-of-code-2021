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


(defn result1-optimized []
  (let [input (read-input "day1.txt"
                          :alter-fn read-string)]
    (->> (partition 2 1 input)
         (map (fn [[a b]] (> a b)))
         (filter true?)
         count)))

(defn result-1-bis []
  (let [init (->> (read-input "day1.txt")
                  (partition 3 1)
                  (map #(apply + %)))]
    init))
