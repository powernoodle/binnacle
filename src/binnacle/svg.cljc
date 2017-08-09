(ns binnacle.svg
  (:require [hickory.core :as hickory]
            [hickory.render :as render]))

(defn empty-string?
  [s]
  (and (string? s) (re-matches #"\s+$" s)))

(defn clean-hiccup
  "Remove and empty spaces between tags"
  [[tag attrs & children]]
  [tag attrs (remove empty-string? children)])

(defn as-hiccup
  [file]
  (->> (slurp file)
       hickory/parse-fragment
       (map hickory/as-hiccup)
       (remove string?) ;; remove comments and doctype
       first
       clean-hiccup))

(defn as-html
  [hiccup]
  (render/hiccup-to-html [hiccup]))
