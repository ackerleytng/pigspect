(ns pigspect.interface
  (:require [pigspect.core :refer [variables-parser]]))

(defn parseVariables [s]
  (clj->js (variables-parser s)))

(defn variablesValid [s]
  (let [parsed (variables-parser s)]
    (not (map? parsed))))
