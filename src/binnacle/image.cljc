(ns binnacle.image
  (:require [clojure.string :as string]))

(defn fill-change
  "image: String of SVG contents
   fill-changes: List of Vectors of hexidecimal color pairs
                 The first is the color to replace and the second is what
                 it will be replaced with"
  [image fill-changes]
  (reduce #(string/replace %1 (first %2) (second %2))
          image
          fill-changes))
