(defproject com.powernoodle/binnacle "0.3.3"
  :description "Binnacle provides images and fonts as data"
  :url "http://github.com/powernoodle/binnacle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/data.codec "0.1.0"]]
  :source-paths ["src"]
  :main binnacle.core
  :aot :all)
