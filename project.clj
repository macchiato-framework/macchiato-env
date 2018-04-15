(defproject macchiato/env "0.0.6"
  :description "a library for managing environment settings from different sources"
  :url "https://github.com/macchiato-framework/macchiato-env"
  :scm {:name "git"
        :url  "https://github.com/macchiato-framework/macchiato-env.git"}
  :license {:name "MIT License"
            :url  "http://opensource.org/licenses/MIT"}
  :clojurescript? true
  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/clojurescript "1.9.293" :scope "provided"]
                 [macchiato/fs "0.0.7"]]
  :plugins [[codox "0.6.4"]
            [macchiato/lein-npm "0.6.6"]
            [lein-doo "0.1.7"]
            [lein-cljsbuild "1.1.7"]]
  :npm {:name "@macchiato/env"
        :write-package-json true
        :private false
        :directories {:lib "src"}
        :files ["src/*"]
        :author {:name "Dmitri Sotnikov"
                 :email "dmitri.sotnikov@gmail.com"
                 :url "http://yogthos.net/"}
        :dependencies []}
  :profiles {:test
             {:doo {:build "test"}
              :cljsbuild
              {:builds
               {:test
                {:source-paths ["src" "test"]
                 :compiler     {:main          macchiato.test.runner
                                :output-to     "target/test/core.js"
                                :target        :nodejs
                                :optimizations :none
                                :source-map    true
                                :pretty-print  true}}}}}}

  :aliases
  {"test"
   ["do"
    ["npm" "install"]
    ["clean"]
    ["with-profile" "test" "doo" "node"]]})
