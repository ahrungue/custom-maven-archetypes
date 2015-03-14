#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Álvaro
 * @since 05/06/14.
 */
@Service
public class FileUploadServices {

    @Value("${symbol_dollar}{log.folder.path}")
    private String folderPath;

    public void saveFile( MultipartFile multipartFile ){

        String fileName = multipartFile.getOriginalFilename();
        String fileExtension = fileName.split("${symbol_escape}${symbol_escape}.")[1];

        //Verificar se o diretorio existe
        if( !(new File(this.folderPath).exists()) ){
            new File(this.folderPath).mkdirs();
        }
        String newFileName = "file" + "." + fileExtension;
        File file = new File(this.folderPath +  newFileName );
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }   //fim saveFile()

}//Fim class FileUploadServices
