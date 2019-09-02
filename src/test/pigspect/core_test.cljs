(ns pigspect.core-test
  (:require [cljs.test :as t :refer [deftest testing is]]
            [pigspect.variables :as v]))

(deftest portvar-tests
  (testing "description"
    (is (= nil (v/parse-variables "portvar HTTP_PORTS 80")))))
