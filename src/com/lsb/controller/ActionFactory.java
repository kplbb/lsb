package com.lsb.controller;


import com.lsb.admin.controller.action.*;
import com.lsb.controller.action.*;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory () {}
	public static ActionFactory getInstance() {
		return instance;
	}


public Action getAction(String command) {
	Action action = null;
	
	System.out.println("ActionFactory : " + command);
	
	if(command.equals("index"))	{
		action = new IndexAction();
	} else if(command.equals("contract")) {
		action = new ContractAction();
	 } else if(command.equals("login_form")) {
		action = new LoginFormAction();
	 }	else if (command.equals("join"))	{
			action = new JoinAction();  
	 } else if(command.equals("login")) {
		action = new LoginAction();
	} else if(command.equals("logout")) {
		action = new LogoutAction();  
	} else if (command.equals("new_arrivals"))	{
		action = new NewArrivalsAction();
	} else if (command.equals("footwear_view_all"))	{
		action = new FootwearViewAllAction();  
	} else if (command.equals("category"))	{
		action = new ProductKindAction();
	} else if (command.equals("product_detail")) {
		action = new ProductDetailAction();
	} else if(command.equals("apparel_view_all")) {
		action = new ApparelViewAllAction();
	} else if(command.equals("library_list")) {
		action = new LibraryListAction();
	} else if(command.equals("id_check_form")) {
		action = new IdCheckFormAction();
	} else if(command.equals("about_us")) {
		action = new AboutUsAction();
	} else if(command.equals("cart_list")) {
		action = new CartListAction();
	} else if (command.equals("product_detail")) {
		action = new ProductDetailAction();
	} else if (command.equals("cart_insert")) {
		action = new CartInsertAction();
	} else if (command.equals("cart_delete")) {
		action = new CartDeleteAction();
	}  else if (command.equals("order_insert")) {
		action = new OrderInsertAction();
	}  else if (command.equals("order_all")) {
		action = new AllOrderAction();
	} else if (command.equals("order_list")) {
		action = new OrderListAction();
	} else if (command.equals("mypage")) {
		action = new MyPageAction();
	} else if (command.equals("order_detail")) {
		action = new OrderDetailAction();  
	} else if (command.equals("library_view")) {
		action = new LibraryViewAction();
	/*-------------ADMIN-----------------------------------------------------*/
	} else if(command.equals("admin_login_form")) {
		action = new AdminLoginFormAction();
	} else if(command.equals("admin_login")) {
		action = new AdminLoginAction();
	} else if(command.equals("admin_logout")) {
		action = new AdminLogoutAction();
	} else if(command.equals("admin_product_list")) {
		action = new AdminProductListAction(); 
	} else if (command.equals("admin_product_write_form")) {
		action = new AdminProductWriteFormAction();
	} else if(command.equals("admin_product_write"))  {
		action = new AdminProductWriteAction();
	} else if(command.equals("admin_product_detail")) {
		action = new AdminProductDetailAction ();
	} else if(command.equals("admin_product_update_form")) {
		action = new AdminProductUpdateFormAction();
	} else if(command.equals("admin_product_update"))  {
		action = new AdminProductUpdateAction();
	} else if(command.equals("admin_order_list"))  {
		action = new AdminOrderListAction();
	} else if(command.equals("admin_order_save"))  {
		action = new AdminOrderSaveAction();
	} else if(command.equals("admin_member_list"))  {
		action = new AdminMemberListAction();
	} else if(command.equals("admin_lib_list"))  {
		action = new AdminLibListAction();
	} else if(command.equals("admin_lib_detail")) {
		action = new AdminLibListDetailAction();
	} else if(command.equals("admin_lib_repsave")) {
		action = new AdminLibRepsaveAction() ;
	} else if(command.equals("admin_product_list_by_name")) {
		action = new AdminProductListByName() ;
	} else if(command.equals("newsemail_add")) {
		action = new NewsEmailAddAction() ;
	}else if (command.equals("admin_lib_write_form")) {
		action = new AdminLibWriteFormAction();
	}else if (command.equals("admin_lib_write")) {
		action = new AdminLibWriteAction();
	}
		return action;
	}
}
