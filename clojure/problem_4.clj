;; Project Euler - Problem 4

(ns euler.problem-4
  (:require [clojure.string :as string]))

(defn palindrome []
  (some #(when (some? %) %)
   (map largest-divisor
        (reverse
         (map
          #(read-string (str % (str/reverse (str %))))
          (range 100 997))))))

(defn largest-divisor [n]
  (some #(when (zero? (mod n %)) [n % (/ n %)])
        (range 1000 (int (/ n 1000)) -1)))
