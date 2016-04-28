(ns binnacle.core
  (:require [binnacle.codec :as codec]
            [binnacle.mime :as mime]
    #?(:clj [binnacle.clj.io :as io])))

(defn data-url
  [assets path & fns]
  (str "data:"
       (mime/mime (mime/extension (last path)))
       ";"
       (if (mime/svg? (mime/extension (last path)))
         "utf8,"
         "base64,")
       (-> (reduce #(%2 %1)
                   (get-in assets path)
                   fns)
           (codec/url-encode))))

#?(:clj
(defn assets
  [path]
  (io/file-map path)))
