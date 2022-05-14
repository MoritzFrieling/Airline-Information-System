package businesslogic;

import persistence.StorageService;

import java.net.PasswordAuthentication;

public class LogInManager {

    private final StorageService storageService;

    public LogInManager(StorageService storageService) {
        this.storageService = storageService;
    }

    //================================================================================================================//
    /* Primary-Methods                                                                                                */
    //================================================================================================================//


    public boolean authenticate(PasswordAuthentication passwordAuthentication ) throws Exception {

        String salt = storageService.getSalt(passwordAuthentication.getUserName());
        String passwordHash = AccountManager.hashString(String.copyValueOf(passwordAuthentication.getPassword()),salt);
        PasswordAuthentication data = storageService.getAccountData(passwordAuthentication);
        String should = String.copyValueOf(data.getPassword());
        return passwordHash.contentEquals(should);
    }

    //================================================================================================================//
    /* Helper-Methods                                                                                                 */
    //================================================================================================================//


    public String getSalt(PasswordAuthentication passwordAuthentication) throws Exception {
        return storageService.getSalt(passwordAuthentication.getUserName());

    }

    public String identify(PasswordAuthentication passwordAuthentication){
        return storageService.getPosition(passwordAuthentication.getUserName());
    }
}
