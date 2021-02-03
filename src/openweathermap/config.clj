(ns openweathermap.config
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def api-key (System/getenv "OPENWEATHERMAP_API_KEY"))

(def base-url "http://api.openweathermap.org/data/2.5/")

(def days->url {1 (str base-url "weather")
                5 (str base-url "forecast")})

(def cities (->> "cities.edn"
                 io/resource
                 slurp
                 edn/read-string))

(defn query-params [id]
  {:id    id
   :appid api-key
   :units "metric"})

(defn generate-url [base-url path]
  (str base-url path))

(defn generate-param [days city]
  {:url (days->url days)
   :query-params (query-params (:id city))})

(defn generate-params [days]
  (map (partial generate-param days) cities))

(def cli-options
  [["-l" "--length DAY" "Forecast length"
    :default 1
    :parse-fn #(Integer/parseInt %)
    :validate [#{1 5} "Must be either 1 or 5"]]])
