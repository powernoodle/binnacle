(ns binnacle.core
  (:require [binnacle.codec :as codec]
            [binnacle.mime :as mime]
            [binnacle.svg :as svg]
            #?(:clj [binnacle.clj.io :as io])))

(defn data-url
  [assets path]
  (let [mime (mime/mime path)
        resource (get-in assets path)]
    (str "data:" mime ";"
         (if (= mime "image/svg+xml")
           (str "utf8," (codec/url-encode (svg/as-html resource)))
           (str "base64," (codec/base64-encode resource))))))

#?(:clj (defn assets [path] (io/file-map path)))
