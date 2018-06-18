package com.pnpStore.controller;

//imported files for OrderController class
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pnpStore.model.Customer;
import com.pnpStore.service.UserService;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

//Marks that class is a Spring MVC Controller
@Controller

public class LoginController {
	
        //@Autowired - use annotation to get rid of the setter method eg private Name name = new NameImpl(); 
        //Object from Service - UserService
	@Autowired
	private UserService userService;
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	//@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Customer user = new Customer();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed
        //@Valid - to valid user for registeration
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Customer user, BindingResult bindingResult) {
	ModelAndView modelAndView = new ModelAndView();
	Customer userExists = userService.findUserByEmail(user.getEmail());
	if (userExists != null) 
        {
            bindingResult
            .rejectValue("email", "error.user",
            "There is already a user registered with the email provided");
        }
	if (bindingResult.hasErrors()) 
        {
            modelAndView.setViewName("registration");
	} 
        else 
        {   userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Customer());
            modelAndView.setViewName("registration");
	}
            return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
	@RequestMapping(value="/customer/customerHome", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName());
		modelAndView.setViewName("customer/customerHome");
		return modelAndView;
                
	}
	
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
	@RequestMapping(value="/addProducts", method = RequestMethod.GET)
	public ModelAndView addProducts(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addProducts");
		return modelAndView;
	}
        
        @RequestMapping(value="/addAddress", method = RequestMethod.GET)
        	public ModelAndView addAdd(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addAddress");
		return modelAndView;
	}
        
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
	/*@RequestMapping(value="/addAddress", method = RequestMethod.GET)
	public ModelAndView addAddress(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addAddress");
		return modelAndView;
	}*/
        
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/editProducts", method = RequestMethod.GET)
	public ModelAndView editProducts(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editProducts");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/customerAdminView", method = RequestMethod.GET)
	public ModelAndView customerAdminView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customerAdminView");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/customerEditDetails", method = RequestMethod.GET)
	public ModelAndView customerEditDetails(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customerEditDetails");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/productsView", method = RequestMethod.GET)
	public ModelAndView productsView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productsView");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/orderView", method = RequestMethod.GET)
	public ModelAndView orderView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderView");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/viewCartForm", method = RequestMethod.GET)
	public ModelAndView viewCartForm(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewCartForm");
		return modelAndView;
	}
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value = "/customer/adminHome")
        public ModelAndView adminHome()
        {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("customer/adminHome");
            return modelAndView;
        }
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        @RequestMapping("/default")
        protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response)
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String role = auth.getAuthorities().toString();
            
            String targetUrl = "";
            if(role.contains("CUSTOMER"))
            {
                targetUrl = "redirect:/customer/customerHome";
            }
            else if (role.contains("ADMIN"))
            {
                targetUrl = "redirect:/customer/adminHome";
            }
            return targetUrl;
        }
}
