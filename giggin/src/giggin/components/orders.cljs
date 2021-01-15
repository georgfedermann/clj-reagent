(ns giggin.components.orders
  (:require [giggin.state :as state]))

(defn orders []
  [:aside
   [:div.order
    [:div.gig__body
     (for [[id quant] @state/orders] ;; e.g. {:gig-11 3, :gig-06 2, :gig-05 8, :gig-09 3}
       [:div.item {:key id}
        [:div.img
         [:img {:src (get-in @state/gigs [id :img])
                :alt (get-in @state/gigs [id :title])}]]
        [:div.content
         [:p.title (str (get-in @state/gigs [id :title]) " \u00D7 " quant)]]
        [:div.action
         [:div.price (* (get-in @state/gigs [id :price]) quant)]]])]]])
