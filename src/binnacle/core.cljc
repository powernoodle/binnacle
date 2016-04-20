(ns binnacle.core
  (:require [binnacle.codec :as codec]
            [binnacle.mime :as mime])
  #?(:clj  (:require [binnacle.clj.io :as io])))

#?(:cljs
(enable-console-print!))

(defn data-url
  [files path]
  (str "data:"
       (mime/mime (mime/extension (last path)))
       ";"
       (if (mime/svg? (mime/extension (last path)))
         "utf8,"
         "base64,")
       (get-in files path)))

#?(:clj
(defn assets
  [path]
  (io/file-map path)))

(defn -main
  []
  (spit "resources/images.edn" (assets "resources")))
