#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.daos;

import ${package}.models.Group;
import ${package}.models.User;
import ${package}.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Álvaro Rungue
 * @since 10/01/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/spring.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
@ActiveProfiles(profiles = "test")
public class UserDAOTest {

	@Autowired
	private UserService userService;

	@Before
	public void initDB(){
		User user = new User();
		user.setEnabled(true);
		user.setName("User for Test");
		user.setLogin("testeLogin");
		user.setPassword("pass");
		user.setCpf("000.000.000-00");
		user.setEmail("teste@email.com");
		user.setAuthorities(new ArrayList<Group>(){{
			add(new Group(){{
				setName("TEST");
			}});
		}});
		this.userService.create(user);
	}//fim initDB()

	@Test
	public void testGetUserAuthorities(){
		User user = this.userService.findByUniqueAttribute("login","testeLogin");
		Group group = user.getAuthorities().stream().findAny().orElse(null);
		assertNotNull("Group do usuário não pode ser nulo!", group);
		final String roleName = "ROLE_TEST";
		assertTrue("Nome da Autoridade cadastrada deve ser igual ROLE_TEST", roleName.equals("ROLE_" + group.getName().toUpperCase()));
	}//fim testGetUserAuthorities()

	@After
	public void cleanDB(){
		this.userService.findAll().stream().forEach(userService::delete);
	}//fim cleanDB()

}//fim class UserDAOTest
