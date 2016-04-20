(ns binnacle.clj.io
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.data.codec.base64 :as b64]
            [binnacle.codec :as codec]
            [binnacle.mime :as mime]))

(defn file-contents
  [file]
  (str/trim-newline (slurp file)))

(defn file-bytes
  [file]
  (with-open [reader (io/input-stream (.getPath file))]
    (let [length (.length file)
          buffer (byte-array length)]
      (.read reader buffer 0 length)
      buffer)))

(defn files-in-dir
  [resources-path]
  (let [files (file-seq (io/file resources-path))]
    (filter #((some-fn mime/image? mime/font?) (mime/extension (.getPath %)))
            files)))

(defn path
  [file]
  (vec (map keyword
            (str/split (.getPath file) #"/"))))

(defn file-map
  [resources-path]
  (reduce #(assoc-in %1
                     (first %2)
                     (second %2))
          {}
          (map #(vector (path %)
                        (if (mime/svg? (mime/extension (.getPath %)))
                          (file-contents %)
                          (codec/encode (file-bytes %))))
               (files-in-dir resources-path))))
