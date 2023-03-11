(ns main
  (:require [qbits.alia :as alia]
            [missionary.core :as m]))

(comment
  (def s(alia/session))
  (alia/execute s "create keyspace test with replication  = {'class': 'SimpleStrategy', 'replication_factor' : 1}")
  (alia/execute s "create table test.foo (a bigint, primary key (a))")
  (alia/execute s "insert into test.foo (a) values (1)")
  (alia/execute s "select * from test.foo")

  (m/? (m/reduce conj (m/subscribe (.executeReactive s "select * from test.foo"))))
  )
