(ns binnacle.mime
  (:require [clojure.string :as string]))

(defn svg? [ext] (= ext "svg"))

(defn font? [ext] (string/starts-with? ext "woff"))

(defn image? [ext] (contains? #{"png" "jpg" "gif" "svg"} ext))

(defn extension [filename] (last (string/split (name filename) #"\.")))

(defn mime
  [path]
  (let [ext (extension (last path))]
    (cond
      (image? ext) (if (svg? ext)
                     (str "image/" ext "+xml")
                     (str "image/" ext))
      (font? ext) (str "application/x-font-" ext))))
