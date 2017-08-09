(defproject com.powernoodle/binnacle "0.3.4"
  :description "Binnacle provides images and fonts as data"
  :url "http://github.com/powernoodle/binnacle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [hickory "0.7.1"]]
  :source-paths ["src"]
  :profiles {:uberjar {:aot :all}})
