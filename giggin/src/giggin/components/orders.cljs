(ns giggin.components.orders
  (:require [giggin.components.checkout-modal :refer [checkout-modal]]
            [giggin.helpers :as helpers]
            [giggin.state :as state]))

(defn total []
  (->> @state/orders
       (map (fn [[id quant]] (* quant (get-in @state/gigs [id :price]))) @state/orders)
       (reduce +)))

(defn orders []
  [:aside
   (let [remove-from-order #(swap! state/orders dissoc %)
         reset-order #(reset! state/orders {})]
     (if (empty? @state/orders)
       [:div.empty
        [:div.title "You don't have any orders"]
        [:div.subtitle "Cick on a + button to add an order"]]
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
             [:div.price (-> (* (get-in @state/gigs [id :price]) quant)
                             (helpers/format-price))]
         ;; add event listener to remove items from the order list
             [:button.btn.btn--link.tooltip {:data-tooltip "Remove"
                                             :on-click #(remove-from-order id)}
              [:i.icon.icon--cross]]]])]
        [:div.total
         [:hr]
         [:div.item
          [:div.content "Total"]
          [:div.action
           [:div.price (helpers/format-price (total))]]
          [:button.btn.btn--link.tooltip {:data-tooltip "Remove all"
                                          :on-click #(reset-order)}
           [:i.icon.icon--delete]]]
         [checkout-modal]]]))])
