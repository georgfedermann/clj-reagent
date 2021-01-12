(ns giggin.components.gigs
  (:require [giggin.state :as state]))

(defn gigs []
  ;; add element <div class="gigs" /> and inside display all the
  ;; gig items to the user.
  ;; Do not use for/while loop, but map function.
  [:main
    [:div.gigs

     (for [gig (vals @state/gigs)]
       [:div.gig {:key (:id gig)}
        [:img.gig__artwork {:src (:img gig) :alt "alt"}]
        [:div.gig__body
         [:div.gig__title
          [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
           [:i.icon.icon--plus]] (:title gig)]
         [:p.gig__price (:price gig)]
         [:p.gig__desc (:desc gig)]]])]])
