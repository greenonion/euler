;; Project Euler - Problem 2
;;
;; Observe that every third Fibonacci number is even.
;; Use Fibonacci closed form expression.
;; Find (by hand) that F_33 is the last under 4 million.
;; Sum every third Fibonacci number from 3 to 33.

(ns euler.problem-2)

(defn fib [n]
  (let [phi (/ (+ 1 (Math/sqrt 5)) 2)
        psi (- 1 phi)]
    (int
     (/
      (- (Math/pow phi n)
         (Math/pow psi n))
      (Math/sqrt 5)))))

(reduce + (map #(fib %) (range 3 34 3)))
