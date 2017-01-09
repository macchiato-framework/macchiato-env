(ns macchiato.test.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [macchiato.test.env.core-test]))

(doo-tests 'macchiato.test.env.core-test)
