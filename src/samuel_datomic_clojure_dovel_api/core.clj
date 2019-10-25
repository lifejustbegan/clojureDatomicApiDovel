(ns samuel_datomic_clojure_dovel_api.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response)
  (:require [compojure.route :as route]
            [samuel_datomic_clojure_dovel_api.home :as home]))

(defn conn nil)


(defn add-project-creator [creator]
  @(d/transact conn [{:db/id (d/tempid :db.part/user)
                      :creator/name creator}]))
;; using datalog syntax
(defn find-all-creators []
  (d/q '[:find ?creator-name
         :where [_ :creator/name ?creator-name]]
       (d/db conn)))

(defn foo [x] (str "Hello, " x))

(defroutes test_routes
  (GET "/" [] (home/home-page))
  (GET "/api" [] (response {:project_creator "Samuel Tilahun" :date_created "10/25/29" :project_for  "Dovel"}))
  (route/resources "/"))
(def app (wrap-json-response test_routes))
