(ns binnacle.clj.io
  (:require [binnacle.codec :as codec]
            [binnacle.mime :as mime]
            [binnacle.svg :as svg]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(defn file-bytes
  [file]
  (with-open [reader (io/input-stream (.getPath file))]
    (let [length (.length file)
          buffer (byte-array length)]
      (.read reader buffer 0 length)
      buffer)))

(defn files-in-dir
  [resources-path]
  (->> (file-seq (io/file resources-path))
       (filter #((some-fn mime/image? mime/font?)
                 (mime/extension (.getPath %))))))

(defn path
  [file]
  (map keyword (string/split (.getPath file) #"/")))

(defn file-map
  [resources-path]
  (reduce #(assoc-in %1 (first %2) (second %2))
          {}
          (map #(vector (path %)
                        (if (mime/svg? (mime/extension (.getPath %)))
                          (svg/as-hiccup %)
                          (codec/base64-encode (file-bytes %))))
               (files-in-dir resources-path))))
