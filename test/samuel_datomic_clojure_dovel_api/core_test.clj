(ns samuel_datomic_clojure_dovel_api.core-test
  (:require [expectations :refer :all]
            [samuel-datomic-clojure-dovel-api.core :refer :all]))

(defn create-empty-in-memory-db []
  (let [uri "datomic:mem://project-creators-test-db"]
    (d/delete-database uri)
    (d/create-database uri)
    (let [conn (d/connect uri)
          schema (load-file "resources/datomic/schema.edn")]
      (d/transact conn schema)
      conn)))

(expect #{["sammy"]}
        (with-redefs [conn (create-empty-in-memory-db)]
        (do
         (add-project-creator "sammy")
         (find-all-creators)))
