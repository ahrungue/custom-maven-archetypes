#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.daos;

import ${package}.generics.GenericDAO;
import ${package}.models.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Repository
public class UserDAO extends GenericDAO<User> {

	public User getUser( String login, String password ){
		//Retornar apenas um Objeto ou null, pois as restrições são UNIQUE
		return super.eqExpressions(Restrictions.eq("login",login), Restrictions.eq("password",password))
				.stream().findAny().orElse(null);
	}//getUser()

}//fim class UserDAO
