#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import ${package}.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Álvaro Rungue
 * @since 26/12/14.
 */
@Controller
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@RequestMapping( value ="/login", method = RequestMethod.GET)
	public String auth(HttpServletResponse response){
		response.setStatus(401);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if(!authentication.getName().equals("anonymousUser")){
			return "redirect:/";
		}//fim if(anonymousUser)

		return "/WEB-INF/views/auth.jsp";
	}//fim auth()

	@RequestMapping( value ="/setUserSession", method = RequestMethod.GET)
	public void setUserSession( HttpServletRequest request, HttpServletResponse response){
		HttpSession session = this.userService.setUserSession();
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//fim setUserSession()

}//fim class AuthenticationController
