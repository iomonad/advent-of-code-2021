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

(defn day02-bis []
  (letfn [(phys [{:keys [p d aim] :as state} ins x]
            (-> state
                (update :p + x)
                (update :d + (* aim x))))]
    (->> (read-input "day2.txt")
         (map parse-entry)
         (reduce (fn [state [ins x]]
                   (cond-> state
                     (= :up ins) (update :aim - x)
                     (= :down ins) (update :aim + x)
                     (= :forward ins) (phys ins x)))
                 {:p 0 :d 0 :aim 0})
         ((juxt :p :d))
         (apply *))))


(comment
  (time (day02))
  (time  (day02-bis)))
