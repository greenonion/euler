(ns euler.problem-3)

;; Original and sub-optimal (but working!) implementation used to
;; arrive at the solution.

(defn prime? [n]
  (not-any? zero?
            (map #(mod n %) (range 2 (+ (Math/sqrt n) 1)))))

(defn prime-factor [n]
  (some #(when (prime? %) %)
          (filter integer?
                  (map #(/ n %) (range 2 (/ n 2))))))


;; Clojure implementation of the suggested algorithm.

(defn reduce-by-factor [n f]
  (loop [n n
         f f]
    (cond
      (= n 1) f
      (zero? (mod n f)) (recur (/ n f) f)
      (> f (Math/sqrt n)) n
      :else (recur n (+ f 2)))))

(defn largest-prime-factor [n]
  ;; quickly reduce even numbers
  (if (zero? (mod n 2))
    (reduce-by-factor
     (loop [n n]
       (if (zero? (mod n 2))
         (recur (/ n 2))
         n))
     3)
    (reduce-by-factor n 3)))

;; Posible improvements so this becomes more Clojure-ian:
;; * generate factors as a lazy list 3..sqrt(N) in steps of 2
;; * lazily iterate over that list and reduce N
