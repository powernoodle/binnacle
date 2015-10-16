(defproject com.powernoodle/binnacle "0.1.1"
  :description "Binnacle constructs hash-maps of all image data within a directory"
  :url "http://github.com/powernoodle/binnacle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]]
  :source-paths ["src"]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-figwheel "0.4.1"]]
  :cljsbuild {
    :builds [{:id "figwheel"
              :source-paths ["src/"]
              :figwheel true
              :optimizations nil
              :compiler {:asset-path "js/out"
                         :output-to "resources/public/js/main.js"
                         :output-dir "resources/public/js/out"}}]})
