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
  [path root-path]
  (str/replace path root-path ""))

(defn construct-map
  [files root-path]
  (into {}
        (map #(hash-map
               (keyword (relative-path (.getPath %) root-path))
               (read-contents %))
             files)))

(defmacro svg-map
  [root-path]
  (let [dir (io/file root-path)
        files (file-seq dir)
        svgs (get-svgs files)]
    (construct-map svgs root-path)))
