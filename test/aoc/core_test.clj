(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.day01 :refer [day01]]
            [aoc.day02 :refer [day02]]
            [aoc.day03 :refer [day03]]
            [aoc.day04 :refer [day04]]
            [aoc.day05 :refer [day05]]
            [aoc.day06 :refer [day06]]
            [aoc.day07 :refer [day07 day07-bis]]))

(deftest day1
  (testing "first star"
    (is (= 701 (day01)))))

(deftest day2
  (testing "first star"
    (is (= 1989014 (day02)))))

(deftest day3
  (testing "first star"
    (is (= 3320834 (day03)))))

(deftest day4
  (testing "first star"
    (is (= 81928 (day04)))))

(deftest day5
  (testing "first star"
    (is (= 5280 (day05)))))

(deftest day6
  (testing "first star"
    (is (= 374927 (day06)))))

(deftest day7
  (testing "first star"
    (is (= 336120 (day07)))
    (is (= 96864235 (day07-bis)))))
