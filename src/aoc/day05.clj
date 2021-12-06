(ns aoc.day05
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]))

(defn hortogonal? [segment]
  (let [[[a b] x] segment]
    (or (.contains x a)
        (.contains x b))))

(defn day05 []
  (letfn [(parse-line [l]
            (->> (str/split l #" -> ")
                 (map #(str/split % #","))
                 (mapv (partial mapv read-string))))
          (brange [a b]
            (if (> a b) (reverse (range b (inc a)))
                (range a (inc b))))
          (overlaps [[[x1 y1] [x2 y2]]]
            (let [xi (brange x1 x2)
                  yi (brange y1 y2)]
              (cond
                (= x1 x2) (map #(vector x1 %) yi)
                (= y1 y2) (map #(vector % y1) xi))))]
    (let [input (->> (read-input "day5.txt" :alter-fn parse-line)
                     (filter hortogonal?))]
      (->> (reduce into [] (keep overlaps input))
           (frequencies)
           vals
           (remove (partial = 1))
           count))))
