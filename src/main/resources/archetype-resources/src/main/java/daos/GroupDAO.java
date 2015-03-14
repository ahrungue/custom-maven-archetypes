#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.daos;

import ${package}.generics.GenericDAO;
import ${package}.models.Group;
import org.springframework.stereotype.Repository;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Repository
public class GroupDAO extends GenericDAO<Group> {

}//fim class GroupDAO
