package com.retail.shop.retailShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.retail.shop.retailShop.Service.RetailService;

@Controller
public class RetailController {
	@Autowired
	RetailService service;
	

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showlogin(ModelMap Map){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showlogin(@RequestParam String name, @RequestParam String password  ,ModelMap model){
		
		boolean isValid = service.validateUser(name, password);
		
		if(!isValid) {
			model.put("errMessage", "invalid Credentials");
			return "login";
		}
			
		model.put("name",name);
		model.put("password", password);
		return "redirect:product";
		
	}
	
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String product(ModelMap model){
		model.put("retails", service.retrieveRetails());
		return "product";
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String product(@RequestParam String search , ModelMap model){
		model.put("result",service.validaSearch(search));
		model.put("retails",service.retrieveRetails());
		return "product";
	}
	
	

	@RequestMapping(value="/wishlist",method=RequestMethod.GET)
	public String wishlist(ModelMap model){
		model.put("wishes", service.retrieveWishes());
		return "wishlist";
	}
	
	@RequestMapping(value="/add-towish",method=RequestMethod.GET)
	public String addToWishlist(@RequestParam int id) {
		service.addWish(id);
		return "redirect:wishlist";
	}
	
	
	
	
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public String cartList(ModelMap model) {
		model.put("carts", service.retrieveCarts());
		model.put("sum", service.cartSum());
		return "cart";
	}
	
	@RequestMapping(value="/add-tocart",method=RequestMethod.GET)
	public String addToCart(@RequestParam int id) {
		service.addCart(id);
		service.removeWish(id);
		return "redirect:cart";
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public String removeCart(@RequestParam int id){	
		service.removeCart(id);
		return "redirect:cart";
	}
	
	
		
}
