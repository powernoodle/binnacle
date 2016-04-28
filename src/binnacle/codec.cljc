(ns binnacle.codec
  #?@(:clj [(:require [clojure.data.codec.base64 :as b64])
            (:import [java.net URLEncoder URLDecoder])]))

(defn url-encode
  [s]
  (some-> s
          str
          #?(:clj  (URLEncoder/encode "UTF-8")
             :cljs (js/encodeURIComponent))
          (.replace "+" "%20")))

(defn url-decode
  [s]
  (some-> s
          str
          #?(:clj  (URLDecoder/decode "UTF-8")
             :cljs (js/decodeURIComponent))))

(defn encode
  [s]
  #?(:clj (String. (b64/encode s) "UTF-8"))
  #?(:cljs (js/btoa s)))

(defn decode
  [s]
  #?(:clj (String. (b64/decode s) "UTF-8"))
  #?(:cljs (js/atob s)))
