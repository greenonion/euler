;; Project Euler - Problem 1
;;
;; multiples of 3 below 1000: 3x, 1 <= x <= 333
;; multiples of 5 below 1000: 5x, 1 <= x < 200
;; the second calculation skips multiples of 3 so they won't be added
;; twice
(+
 (reduce + (map #(* 3 %) (range 1 334)))
 (reduce + (filter #(not= 0 (mod % 3)) (map #(* 5 %) (range 1 200)))))
