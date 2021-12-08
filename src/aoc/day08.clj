(ns aoc.day08
  (:require [aoc.utils :refer :all]
            [clojure.string :as str]))

(defn day8 []
  (->> (read-input "day8.txt")
       (map #(second (str/split % #"\|")))
       (map (fn [e] (-> e str/trim (str/split #" "))))
       (mapcat (partial map count))
       (filter (partial contains? #{2 3 4 7}))
       count))
