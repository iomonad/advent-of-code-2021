(ns aoc.day04
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]
            [clojure.set :as set]
            [clojure.java.io :as io]))

(defn day04 []
  (let [[a & rest] (read-input "day4.txt")
        selection (map #(Integer/parseInt %) (str/split a #","))
        boards (->> (partition-by empty? rest)
                    (remove #(= 1 (count %)))
                    (map (fn [b]
                           (mapcat (fn [l] (->> (str/split l #" ")
                                                (remove empty?)
                                                (map read-string))) b)))
                    (map-indexed (fn [i c] {i c}))
                    (apply merge))
        winner (atom nil)]
    (reduce (fn [acc i]
              (->> (for [[k v] boards]
                     (let [res (cond-> {}
                                 (.contains v i) (assoc k #{i}))]
                       (if (and (nil? @winner)
                                (= 25 (count (get acc k))))
                         (reset! winner [(get acc k) i]))
                       res))
                   (apply merge)
                   (merge-with set/union acc)))
            (->> (map (fn [e] {e (sorted-set)})
                      (keys boards))
                 (apply merge))
            selection)
    (let [[v a] @winner
          u (set/difference (set selection) v)]
      (* (apply + u) a))))
