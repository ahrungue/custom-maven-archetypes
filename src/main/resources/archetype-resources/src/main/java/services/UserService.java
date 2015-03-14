#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import ${package}.daos.UserDAO;
import ${package}.generics.GenericService;
import ${package}.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Service
public class UserService extends GenericService<User> {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User findByUniqueAttribute( String attributeName, String attributeValue ){
		return userDAO.byUniqueAttribute(attributeName, attributeValue);
	}//fim findByUniqueAttribute()

	@Transactional
	public HttpSession setUserSession(){

		//Recuperar os dados da authenticação do usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		//Recuperar a sessão do usuario
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttributes.getRequest().getSession();

		//Busvar no banco o usuario atualmente conectado nesse contexto
		User currentUser = this.findByUniqueAttribute("login", auth.getName());

		//Adiciona Informaçoes do usuário na sessão
		if(auth.isAuthenticated()){
			session.setAttribute("id",         currentUser.getId());
			session.setAttribute("name",       currentUser.getName());
			session.setAttribute("email",      currentUser.getEmail());
			session.setAttribute("logged",     true);
			session.setAttribute("instance",   currentUser.getInstance() );
			session.setAttribute("last_login", currentUser.getLastLogin());
		}//fim if()

		//Atualizar o ultimo login na sessao
		currentUser.setLastLogin(new Date());
		this.userDAO.update(currentUser);

		return session;
	}//fim setUserSession()

	@Transactional
	public User findByPassword( String login, String password ){
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
		return this.userDAO.getUser(login, shaPasswordEncoder.encodePassword(password, null));
	}//findByPassword

}//fim class UserService
