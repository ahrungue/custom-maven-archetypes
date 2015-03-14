#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import ${package}.services.FileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Álvaro Rungue
 * @since 04/06/14.
 */
@RestController
@RequestMapping(value = "/upload")
public class FileUploadController {

    @Autowired
    private FileUploadServices fileUploadServices;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> save( @RequestBody MultipartFile file ){
        Map<String,Object> map = new HashMap<String, Object>();
        fileUploadServices.saveFile(file);
        return map;
    }//fim save()

}//Fim class FileUploadController
