# finance

> Anyone who believes that exponential growth can go on forever in a finite world is either a madman or an economist.  
> _- Kenneth Boulding_

A Clojure library designed to help you calculate financial decision for investments.

## Usage

```clojure
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
```

## License

Copyright © 2022 Simon Neutert

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
