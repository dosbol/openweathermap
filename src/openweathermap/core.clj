(ns openweathermap.core
  (:require [clojure.tools.cli :as cli]
            [clj-http.client :as client]
            [openweathermap.config :as config])
  (:gen-class))

(defn exit [code message]
  (let [out (if (zero? code) *out* *err*)]
    (binding [*out* out]
      (println message)))
  (System/exit code))

(defn pull-data! [{:keys [url query-params]}]
  (-> (client/get url {:query-params query-params :as :json})
      :body))

(defn do-run! [length]
  (->> length
       config/generate-params
       (pmap pull-data!)
       (exit 0)))

(defn -main
  [& args]
  (let [{:keys [options errors]} (cli/parse-opts args config/cli-options)]
    (if errors
      (exit 1 errors)
      (do-run! (:length options)))))
