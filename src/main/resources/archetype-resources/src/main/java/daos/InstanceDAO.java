#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.daos;

import ${package}.generics.GenericDAO;
import ${package}.models.Instance;
import org.springframework.stereotype.Repository;

/**
 * Created by alvaro on 05/06/14.
 */
@Repository
public class InstanceDAO extends GenericDAO<Instance> {

}//fim InstanceDAO
