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

(defn cont-divide [n f]
  (loop [n n
         f f]
    (if (= (mod n f) 0)
      (recur (/ n f) f)
      n)))

(defn reduce-by-factor [n f]
  (let [orig n
        limit (Math/sqrt n)]
      (loop [n n
             f f]
         (cond
           (= n 1) f
           (= (mod n f) 0) (recur (cont-divide n f) f)
           (> n limit) orig
           :else (recur n (+ f 2))))))

(defn largest-prime-factor [n]
  (let [f 2]
    (if (= (mod n f) 0)
      (reduce-by-factor (cont-divide n f) 3)
      (reduce-by-factor n 3))))

;; Posible improvements so this becomes more Clojure-ian:
;; * generate factors as a lazy list 3..sqrt(N) in steps of 2
;; * lazily iterate over that list and reduce N
