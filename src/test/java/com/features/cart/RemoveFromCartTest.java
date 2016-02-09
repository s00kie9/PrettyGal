package com.features.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.CartSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class RemoveFromCartTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public NavigationSteps navigationSteps;

	@Steps
	public ProductSteps productSteps;

	@Steps
	public CartSteps cartSteps;

	@Test
	public void remove_products_from_cart_until_empty() {
		navigationSteps.open_home_page_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nTH_product(0);
		productSteps.add_to_cart();
		navigationSteps.click_on_curtain();

		navigationSteps.open_quick_view_for_nTH_product(1);
		productSteps.add_to_cart();
		navigationSteps.click_on_curtain();

		navigationSteps.open_quick_view_for_nTH_product(2);
		productSteps.add_to_cart();

		cartSteps.click_view_cart();

		// remove products one by one
		// cartSteps.remove_nTH_product_from_cart(0);
		// cartSteps.remove_nTH_product_from_cart(0);
		// cartSteps.remove_nTH_product_from_cart(0);

		// or remove products in one step
		cartSteps.remove_all_products_from_cart();

		cartSteps.check_cart_is_empty_element();
		cartSteps.check_cart_subtotal_is("$0.00");
	}
}