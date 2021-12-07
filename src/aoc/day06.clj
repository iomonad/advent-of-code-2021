(ns aoc.day06
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.core.reducers :as r]))

(defn mk-cycle [state]
  (let [new (count (filter zero? state))]
    (apply conj (map (fn [e] (if (zero? e) 6 (dec e))) state)
           (repeatedly new (constantly 8)))))


(defn day06 []
  (let [input (->> (str/split (slurp (io/resource "day6.txt"))
                              #",")
                   (map read-string))]
    (count (reduce (fn [acc i] (mk-cycle acc))
                   input (range 256)))))

(defn day06-bis []
  (let [input (->> (str/split (slurp (io/resource "day6.txt"))
                              #",")
                   (map read-string))]
    (count (r/reduce (fn [acc i] (mk-cycle acc))
                     input (range 256)))))
