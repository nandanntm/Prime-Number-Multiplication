(ns prime-numbers.core-test
  (:require [clojure.test :refer :all]
            [prime-numbers.core :refer :all]))

(deftest test-is-prime?
  (testing "Is it prime numbers?"
           (is (not (is-prime? 14)))
           (is (is-prime? 2))
           (is (is-prime? 3))
           (is (is-prime? 67))
           (is (is-prime? 456267))
           (is (not (is-prime? 211230)))))

(deftest test-get-prime-numbers-list
  (testing "List the prime numbers upto n"
           (is (= [2] (get-prime-numbers-list 1)))
           (is (= [2 3 5 7] (get-prime-numbers-list 4)))
           (is (= [2 3 5 7 9] (get-prime-numbers-list 5)))))

(deftest test-displaying-multiplication-table-of-prime-numbers
  (testing "printing the multiplication table"
           (is (= (with-out-str (-main "4"))
                  (str "\n" "|   |  2 |  3 |  5 |  7 |\n" "|---+----+----+----+----|\n" "| 2 |  4 |  6 | 10 | 14 |\n" "| 3 |  6 |  9 | 15 | 21 |\n" "| 5 | 10 | 15 | 25 | 35 |\n" "| 7 | 14 | 21 | 35 | 49 |\n")))))
