(ns pigspect.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [pigspect.variables :as v]))

(deftest portvar-tests
  (testing "description"
    (is (= [:variable-definitions
            [:variable-definition
             [:portvar
              "portvar"
              " "
              [:variable-name "HTTP_PORTS"]
              " "
              [:portvar-value [:port "80"]]]]]
           (v/parse-variables "portvar HTTP_PORTS 80")))))
