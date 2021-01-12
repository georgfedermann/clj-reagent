(ns giggin.core
  (:require [reagent.core :as r]
            [giggin.components.header :refer [header]]
            [giggin.components.gigs :refer [gigs]]
            [giggin.components.orders :refer [orders]]
            [giggin.components.footer :refer [footer]]))

(defn app ;; this defines the 1st component
  []      ;; put the arguments here
  [:div {:id "container-id" :class "container"}
   [header]
   [gigs]
   [orders]
   [footer]]) ;; JSX makes it easier to write and add HTML in React.
;; above will return a <div class="container" />
;; [:div#container] would return <div id="container" />
;; [:div {:class "container" :id "container-id"}]

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))

(def book {:author "me"})

(println book)