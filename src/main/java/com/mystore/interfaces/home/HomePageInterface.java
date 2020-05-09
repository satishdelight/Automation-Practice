package com.mystore.interfaces.home;

import java.util.List;

public interface HomePageInterface {
	
	public void clickCart();
	
	public List<String> addProductToCart() throws InterruptedException;
	
	public void deleteProductFromCart(String ProductToBeDeleted);
	
	public void searchBox(String searchText);
}
