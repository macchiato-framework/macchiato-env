(defproject macchiato/env "0.0.2"
  :description "a library for managing environment settings from different sources"
  :url "https://github.com/yogthos/macchiato-framework/macchiato-env"
  :scm {:name "git"
         :url "https://github.com/macchiato-framework/macchiato-env.git"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :clojurescript? true
  :dependencies [[macchiato/fs "0.0.1"]]
  :plugins [[codox "0.6.4"]
            [lein-npm "0.6.2"]]
  :npm {:dependencies [
                       ]}
  :profiles {:dev
             {:dependencies [[org.clojure/clojurescript "1.9.293"]]
              :plugins [[lein-cljsbuild "1.1.4"]]}})
