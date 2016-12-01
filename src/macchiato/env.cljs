(ns macchiato.env
  (:require [clojure.string :as s]
            [cljs.reader :as edn]
            [macchiato.fs :as fs]))

(defn- format-key [k]
  (-> k
      (s/lower-case)
      (s/replace-all #"_" "-")
      (keyword)))

(defn env-props []
  (let [env (.-env js/process)]
    (reduce
      (fn [props k]
        (assoc props (format-key k) (aget env k)))
      {}
      (js/Object.keys env))))

(defn file-props [filename]
  (some-> filename
          (fs/slurp)
          (edn/read-string)))

(defn env [& [filename]]
  (let [env-config (env-props)]
    (merge
      env-config
      (file-props (or (:conf env-config) filename)))))
