(ns binnacle.codec
  #?@(:clj [(:require [clojure.data.codec.base64 :as base64])
            (:import [java.net URLEncoder URLDecoder])]))

(defn url-encode
  [s]
  (some-> s #?(:clj  (URLEncoder/encode "UTF-8")
               :cljs (js/encodeURIComponent))
          (.replace "+" "%20")))

(defn url-decode
  [s]
  (some-> s #?(:clj  (URLDecoder/decode "UTF-8")
               :cljs (js/decodeURIComponent))))

(defn base64-encode
  [s]
  #?(:clj (String. (base64/encode s) "UTF-8"))
  #?(:cljs (js/btoa s)))

(defn base64-decode
  [s]
  #?(:clj (String. (base64/decode s) "UTF-8"))
  #?(:cljs (js/atob s)))
