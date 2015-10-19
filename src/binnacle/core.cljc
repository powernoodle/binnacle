(ns binnacle.core
  #?@(:clj [(:require [binnacle.clj.io :as io])
            (:import (java.net URLEncoder URLDecoder))])
  #?(:cljs (:require-macros [binnacle.clj.io :as io])))

#?(:cljs
(enable-console-print!))

(defn mapfn
  [m f]
  (into {} (for [[k v] m] [k (f v)])))

(defn encode
  [s]
  (-> s
      str
      #?(:clj (URLEncoder/encode "UTF-8"))
      #?(:cljs (js/encodeURIComponent))
      (.replace "+" "%20")))

(defn decode
  [s]
  (-> s
      str
      #?(:clj (URLDecoder/decode "UTF-8"))
      #?(:cljs (js/decodeURIComponent))))

(defn css-ready
  [m]
  (mapfn m #(str "url(\"data:image/svg+xml;utf8,"
                 (encode %)
                 "\")")))

(def images
  (css-ready #?(:clj (io/svg-map))
             #?(:cljs (io/svg-map-cljs))))

(defn -main
  []
  (println images)
  (spit "resources/images.edn"
        images))
