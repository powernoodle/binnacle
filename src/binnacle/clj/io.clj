(ns binnacle.clj.io
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn read-contents
  [file]
  (slurp file))

(defn get-svgs
  [files]
  (filter #(.endsWith (.getName %) ".svg")
          files))

(defn relative-path
  [file root-path]
  (-> (.getPath file)
      (str/replace root-path "")
      (str/replace "/" ".")))

(defn clean-name
  [file root-path]
  (-> (relative-path file root-path)
      (str/replace ".svg" "")))

(defn construct-map
  [files root-path]
  (into {}
        (map #(hash-map
               (keyword (clean-name % root-path))
               (read-contents %))
             files)))

(defn svg-map
  []
  (let [root-path "resources/images/"
        dir (io/file root-path)
        files (file-seq dir)
        svgs (get-svgs files)]
    (construct-map svgs root-path)))

(defmacro svg-map-cljs
  []
  (svg-map))
