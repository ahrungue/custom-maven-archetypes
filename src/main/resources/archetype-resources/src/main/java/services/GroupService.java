#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import ${package}.generics.GenericService;
import ${package}.models.Group;
import org.springframework.stereotype.Service;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Service
public class GroupService extends GenericService<Group> {
}//fim class GroupService
