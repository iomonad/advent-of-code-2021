(ns aoc.day04
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]))

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
        first (atom nil)]
    (->> (reduce (fn [acc i]
                   (->> (for [[k v] boards]
                          (do (if (and (nil? @first)
                                       (= 25 (get acc k)))
                                (reset! first k))
                              (cond-> {k 0}
                                (.contains v i) (assoc k 1))))
                        (apply merge)
                        (merge-with + acc)))
                 {} selection))
    (if-let [winner @first]
      (* (apply + (get boards winner)) winner)
      (clojure.pprint/pprint (get boards winner)))))
