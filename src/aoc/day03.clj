(ns aoc.day03
  (:require [aoc.utils :refer :all]
            [clojure.pprint :refer [cl-format]]))

(defn Ɣ [m]
  (->> (for [i (range (count (first m)))]
         (let [s (->> (map #(nth % i) m)
                      frequencies)]
           (key (apply max-key val s))))
       (apply str)))


(defn ε [cm]
  (letfn [(bit-swap [x] (if (= x \0) 1 0))]
    (->> (mapv bit-swap cm)
         (apply str))))


(defn day03 []
  (let [b (->> (read-input "day3.txt")
               (mapv (fn [e] (mapv #(Integer/parseInt (str %)) e)))
               Ɣ)
        e (ε b)]
    (->> (mapv #(Integer/parseInt % 2) [b e])
         (apply *))))

(comment
  (time (println (day03))))
