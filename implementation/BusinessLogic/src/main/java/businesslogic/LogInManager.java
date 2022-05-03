package businesslogic;

import persistence.StorageService;

import java.net.PasswordAuthentication;
import java.util.Arrays;

public class LogInManager {

    private final StorageService storageService;

    public LogInManager(StorageService storageService) {
        this.storageService = storageService;
    }

    //================================================================================================================//
    /* Primary-Methods                                                                                                */
    //================================================================================================================//


    public boolean authenticate(PasswordAuthentication passwordAuthentication ) throws Exception {

        String passwordHash = AccountManager.hashString(Arrays.toString(passwordAuthentication.getPassword()), storageService.getSalt(passwordAuthentication.getUserName()));

        String pw = Arrays.toString(storageService.getAccountData(passwordAuthentication).getPassword());
        return pw.equals(passwordHash);
    }

    //================================================================================================================//
    /* Helper-Methods                                                                                                 */
    //================================================================================================================//


}
