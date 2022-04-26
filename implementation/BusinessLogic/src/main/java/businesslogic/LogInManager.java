package businesslogic;

import persistence.StorageService;

import java.net.PasswordAuthentication;

public class LogInManager {

    private final StorageService storageService;

    public LogInManager(StorageService storageService) {
        this.storageService = storageService;
    }

    //================================================================================================================//
    /* Primary Methods                                                                                                */
    //================================================================================================================//


    public boolean authenticate(String username, String password ){
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication( username, password.toCharArray() );
        return true;
    }

    //================================================================================================================//
    /* Helper Methods                                                                                                 */
    //================================================================================================================//

    private String generateSalt(String str){

        return "bla";
    }

}
