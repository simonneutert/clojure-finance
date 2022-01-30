(ns finance.core)

(defn- discount-rate-at-year
  [rate year]
  (Math/pow (+ 1 (/ rate 100)) year))

(defn- net-capital-return-over-periods
  [list-of-return-and-rate]
  (->> (map-indexed
        (fn [idx [return rate]]
          (let [year (+ 1 idx)]
            (/ return (discount-rate-at-year rate year))))
        list-of-return-and-rate)
       (apply +)))

(defn return-of-interest-at-fixed-rate-for-given-years
  "simple method to calculate the estimated return"
  [investment rate-of-interest years]
  (->> years
       (Math/pow (+ 1 (/ rate-of-interest 100)))
       (* investment)))

(defn years-to-double-investment-at-fixed-rate
  "iterative method to calculate how long it takes to double 
   the investments worth in years for a given rate"
  [rate]
  (loop [investment 100
         years 1]
    (let [roi (return-of-interest-at-fixed-rate-for-given-years investment rate years)]
      (cond
        (> roi (* 2 investment)) years
        :else (recur investment (+ 1 years))))))

(defn net-capital-value-one-year-investment
  "returns the net capital value for a one year investment"
  [investment return rate]
  (let [discounted-net-value (/ return (+ 1 (/ rate 100)))]
    (float (- discounted-net-value investment))))

(defn net-capital-value-over-periods
  "
   returns net capital value for a investment for multiple periods
   
   **example** 

   the investement is 22
   return in the first year is 4 at a rate of 4 (percent)
   return in the first year is 10 at a rate of 4 (percent)
   return in the first year is 12 at a rate of 4 (percent)

   *you would then call this function as:*

   ```clojure
   (net-capital-value-over-periods 22 [[4 4] [10 4] [12 4]])
   ```
   "
  [investment list-of-return-and-rate]
  (-> (net-capital-return-over-periods list-of-return-and-rate)
      (- investment)
      (float)))
