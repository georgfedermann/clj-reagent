(ns giggin.components.gigs
  (:require [giggin.state :as state]))

(defn gigs []
  ;; add element <div class="gigs" /> and inside display all the
  ;; gig items to the user.
  ;; Do not use for/while loop, but map function.
  [:main
    [:div.gigs

     (for [{:keys [id img title price desc]} (vals @state/gigs)]
       [:div.gig {:key id}
        [:img.gig__artwork {:src img :alt "alt"}]
        [:div.gig__body
         [:div.gig__title
          [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
           [:i.icon.icon--plus]] title]
         [:p.gig__price price]
         [:p.gig__desc desc]]])]])
