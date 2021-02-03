(ns openweathermap.transform
  (:require [clojure.spec.alpha :as s]))

(s/def ::->datetime
  (s/conformer
   (fn [value]
     (try
       (str (java.time.Instant/ofEpochSecond value))
       (catch Exception _
         ::s/invalid)))))


(comment

  (s/conform ::->datetime 1612337735)


  ; current weather
  {:coord    {:lon         "City geo location, longitude"
              :lat         "City geo location, latitude"}
   :weather  {:id          "Weather condition id"
              :main        "Group of weather parameters (Rain, Snow, Extreme etc.)"
              :description "Weather condition within the group. You can get the output in your language."
              :icon        " Weather icon id"}
   :main     {:temp        "Temperature."
              :feels_like  "Temperature. This temperature parameter accounts for the human perception of weather."
              :pressure    "Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa"
              :humidity    "Humidity, %"
              :temp_min    "Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas)."
              :temp_max    "Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas)."
              :sea_level   "Atmospheric pressure on the sea level, hPa"
              :grnd_level  "Atmospheric pressure on the ground level, hPa"}
   :wind     {:speed       "Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour."
              :deg         "Wind direction, degrees (meteorological)"
              :gust        "Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour"}
   :clouds   {:all         "Cloudiness, %"}
   :rain     {:1h          "Rain volume for the last 1 hour, mm"
              :3h          "Rain volume for the last 3 hours, mm"}
   :snow     {:1h          "Snow volume for the last 1 hour, mm"
              :3h          "Snow volume for the last 3 hours, mm"}
   :sys      {:type        "Internal parameter"
              :id          "Internal parameter"
              :message     "Internal parameter"
              :country     "Country code (GB, JP etc.)"
              :sunrise     "Sunrise time, unix, UTC"
              :sunset      "Sunset time, unix, UTC"}
   :dt       "Time of data calculation, unix, UTC"
   :base     "Internal parameter"
   :timezone "Shift in seconds from UTC"
   :id       "City ID"
   :name     "City name"
   :cod      "Internal parameter"}
  
  ; 5 days forecasts
  {:cod      "Internal parameter"
   :message  "Internal parameter"
   :city     {:id          "City ID"
              :name        "City name"
              :coord {:lat "City geo location, latitude"
                      :lon "City geo location, longitude"}
              :country     "Country code (GB, JP etc.)"
              :timezone    "Shift in seconds from UTC"}
   :cnt      "A number of timestamps returned in the API response"
   :list     {:dt          "Time of data forecasted, unix, UTC"
              :main       {:temp       "Temperature."
                           :feels_like "This temperature parameter accounts for the human perception of weather."
                           :temp_min   "Minimum temperature at the moment of calculation. This is minimal forecasted temperature (within large megalopolises and urban areas), use this parameter optionally."
                           :temp_max   "Maximum temperature at the moment of calculation. This is maximal forecasted temperature (within large megalopolises and urban areas), use this parameter optionally."
                           :pressure   "Atmospheric pressure on the sea level by default, hPa"
                           :sea_level  "Atmospheric pressure on the sea level, hPa"
                           :grnd_level "Atmospheric pressure on the ground level, hPa"
                           :humidity   "Humidity, %"
                           :temp_kf    "Internal parameter"}
              :weather    {:id          "Weather condition id"
                           :main        "Group of weather parameters (Rain, Snow, Extreme etc.)"
                           :description "Weather condition within the group. You can get the output in your language."
                           :icon        "Weather icon id"}
              :clouds     {:all  "Cloudiness, %"}
              :wind       {:speed  "Wind speed."
                           :deg    "Wind direction, degrees (meteorological)"}
              :visibility "Average visibility, metres"
              :pop        "Probability of precipitation"
              :rain {:3h  "Rain volume for last 3 hours, mm"}
              :snow {:3h  "Snow volume for last 3 hours"}
              :sys {:pod  "Part of the day (n - night, d - day)"}
              :dt_txt     "Time of data forecasted, ISO, UTC"}}


  :end)
