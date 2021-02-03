(ns openweathermap.config-test
  (:require [clojure.test :refer :all]
            [openweathermap.config :refer :all]))

(deftest generate-params-test
  (with-redefs [api-key "abc"
                cities [{:id 123 :name "London"}
                        {:id 456 :name "Athens"}]]
    (is (= [{:url "http://api.openweathermap.org/data/2.5/weather"
             :query-params {:id 123
                            :appid "abc"
                            :units "metric"}}
            {:url "http://api.openweathermap.org/data/2.5/weather"
             :query-params {:id 456
                            :appid "abc"
                            :units "metric"}}]
           (generate-params 1)))
    (is (= [{:url "http://api.openweathermap.org/data/2.5/forecast"
             :query-params {:id 123
                            :appid "abc"
                            :units "metric"}}
            {:url "http://api.openweathermap.org/data/2.5/forecast"
             :query-params {:id 456
                            :appid "abc"
                            :units "metric"}}]
           (generate-params 5)))))
