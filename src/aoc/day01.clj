(ns aoc.day01
  (:require [clojure.java.io :as io]
            [com.rpl.specter :as sp]
            [aoc.utils :refer :all]))

(defn result1 []
  (let [input (read-input "day1.txt"
                          :alter-fn read-string)
        state (atom 0)]
    (doseq [c (range (count input))
            :let [current (nth input c)]]
      (if-let [right (nth input (inc c) nil)]
        (if (< right current)
          (swap! state inc))))
    (dec (- (count input) @state))))

(comment
  (time (result1)))
