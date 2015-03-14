#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security;

import ${package}.models.Group;
import ${package}.models.User;
import ${package}.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Álvaro Rungue
 * @since 05/01/15.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		//Recuperar os dados do usuario que será authenticado
		String name     = authentication.getName();
		String password = authentication.getCredentials().toString();

		//Recuperar o usuario
		User user = this.userService.findByPassword(name,password);

		//Lista com as authoridades do usuario
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		//Caso o usuario retornado não seja nulo
		if(user != null){

			//Adicionar as permissoes do usuario
			user.getAuthorities().forEach(group -> grantedAuthorities
					.add(new SimpleGrantedAuthority("ROLE_" + group.getName().toUpperCase())));

			//Autentica usuário
			return new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
		}//fim if(user NOT NULL)

		return null;
	}//fim authenticate()

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}//fim supports()

}//fim class CustomAuthenticationProvider
