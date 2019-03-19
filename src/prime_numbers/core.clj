(ns prime-numbers.core
  (:require  [clojure.pprint :refer [print-table]]))

(defn is-prime? [num]
  (cond
    (= num 2) true
    (not= (rem num 2) 0) true
    :else false))

(defn get-prime-numbers-list [n]
  (loop [i 2
         primes []
         size n
         j 0]
    (if (= (count primes) size)
      primes
      (if (is-prime? i)
        (recur (+ i 1) (assoc primes j i) size (+ 1 j))
        (recur (+ i 1) primes size j)))))

(defn -main [& args]
  (let [n (if (first args) (Integer/parseInt (first args)) 10)
        primes (get-prime-numbers-list n)
        space " "
        prime-numbers (concat [space] primes)
        multiplication (map #(merge {space %} (zipmap primes (map (partial * %) primes))) primes)]
    (print-table prime-numbers multiplication)))
