(ns binnacle.mime
  (:require [clojure.string :as str]))

(defn svg?
  [ext]
  (= ext "svg"))

(defn font?
  [ext]
  (= ext "woff"))

(defn image?
  [ext]
  (contains? #{"png" "jpg" "gif" "svg"} ext))

(defn extension
  [s]
  (last (str/split (name s) #"\.")))

(defn mime
  [ext]
  (cond
    (image? ext)
    (if (svg? ext)
      (str "image/" ext "+xml")
      (str "image/" ext))
    (font? ext)
    (str "application/x-font-" ext)))
