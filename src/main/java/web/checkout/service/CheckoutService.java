package web.checkout.service;

import web.checkout.vo.Checkout;

public interface CheckoutService {

	String processCheckout(Checkout checkout);

}