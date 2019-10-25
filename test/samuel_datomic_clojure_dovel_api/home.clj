(ns samuel_datomic_clojure_dovel_api.home
  (:use hiccup.page hiccup.element))

(defn home-page []
  (html5
    [:html]
    [:head]
    [:body "Hello From home again"]))
