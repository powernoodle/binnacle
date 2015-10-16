(ns binnacle.core
  #?@(:clj [(:require [binnacle.clj.io :as io :refer [svg-map]])
            (:import (java.net URLEncoder URLDecoder))])
  #?(:cljs (:require-macros [binnacle.clj.io :as io :refer [svg-map]])))

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
  (mapfn m #(str "data:image/svg+xml;utf8,"
                 (encode %))))

(defn get-images
  []
  (css-ready (io/svg-map "resources/images/")))
