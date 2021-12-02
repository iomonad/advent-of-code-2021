(ns aoc.day02
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]))

(defn parse-entry [x]
  (let [[ins x] (str/split x #" ")]
    [(keyword ins) (read-string x)]))

(defn day02 []
  (->> (read-input "day2.txt")
       (map parse-entry)
       (reduce (fn [state [ins x]]
                 (cond-> state
                   (= :forward ins) (update :p + x)
                   (= :up ins) (update :d - x)
                   (= :down ins) (update :d + x)))
               {:p 0 :d 0})
       vals
       (apply *)))


(comment
  (ttime (day02))
  )
