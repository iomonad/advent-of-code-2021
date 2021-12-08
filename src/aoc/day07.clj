(ns aoc.day07
  (:require [clojure.string :as str]))

(defn day07 []
  (let [input (->> (str/split (slurp (io/resource "day7.txt"))
                              #",")
                   (map read-string))]
    (->> (range (apply min input) (inc (apply max input)))
         (map (fn [x] (reduce + (map #(Math/abs (- x %)) input))))
         (apply min))))

(defn day07-bis []
  (letfn [(cheapest [x] (/ (* x (inc x)) 2))]
    (let [input (->> (str/split (slurp (io/resource "day7.txt"))
                                #",")
                     (map read-string))]
      (->> (range (apply min input) (inc (apply max input)))
           (map (fn [x] (reduce + (map #(cheapest (Math/abs (- x %))) input))))
           (apply min)))))
