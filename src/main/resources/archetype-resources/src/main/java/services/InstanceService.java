#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import ${package}.generics.GenericService;
import ${package}.models.Instance;
import org.springframework.stereotype.Service;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Service
public class InstanceService extends GenericService<Instance> {
}//fim class InstanceService
