(ns euler.problem-5)

(defn gcd [a b]
  (loop [a a
         b b]
    (let [r (rem a b)]
      (if (zero? r)
        b
        (recur b r)))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn answer []
  (reduce lcm (range 1 20)))
