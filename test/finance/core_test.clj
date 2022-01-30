(ns finance.core-test
  (:require [clojure.test :refer :all]
            [finance.core :refer :all]))

(defn abs
  [x]
  (max x (- x)))

(defn close-to
  [x y epsilon]
  (<= (abs (- x y)) epsilon))

(deftest basic-return-on-investment-test
  (testing "basic return of interest"
    (is (=
         (return-of-interest-at-fixed-rate-for-given-years 100 5 1)
         105.0))))

(deftest return-on-investment-test
  (testing "return of interest after two year"
    (is (=
         (return-of-interest-at-fixed-rate-for-given-years 100 5 2)
         110.25))))

(deftest years-to-double-investment-at-fixed-rate-test
  (testing "time it takes to double investment"
    (is (=
         (years-to-double-investment-at-fixed-rate 5)
         15))))

(deftest net-capital-value-one-year-test
  (testing "the net capital value of a one year investment"
    (is (close-to
         (net-capital-value-one-year-investment 40 70 10)
         23.636364
         1e-4))))

(deftest net-capital-value-over-periods-3-periods-test
  (testing "the net capital value of a 3 year investment with same rate"
    (is (close-to
         (net-capital-value-over-periods 22 [[4 4] [10 4] [12 4]])
         1.7596723
         1e-4))))
