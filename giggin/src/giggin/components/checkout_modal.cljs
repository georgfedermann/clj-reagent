(ns giggin.components.checkout-modal)

(defn checkout-modal []
  [:div.checkout-modal
   [:button.btn.btn--secondary "Checkout"]
   [:div.modal
    [:div.modal__overlay]
    [:div.mocal__container
     [:div.modal__body
      [:div.payment
       [:img.payment-logo {:src "/img/paypal.svg" :alt "Paypal logo"}]
       [:img.payment-logo {:src "/img/stripe.svg" :alt "Stripe logo"}]]]]
    [:div.modal__footer
     [:button.btn.btn--link.float--left "Cancel"]]]])
