(ns binnacle.codec
  #?(:clj (:require [clojure.data.codec.base64 :as b64])))

(defn encode
  [s]
  #?(:clj (String. (b64/encode s) "UTF-8"))
  #?(:cljs (js/btoa s)))

(defn decode
  [s]
  #?(:clj (String. (b64/decode s) "UTF-8"))
  #?(:cljs (js/atob s)))
