package businesslogic;

import datarecords.AccountData;
import persistence.StorageService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class AccountManager {

    private final StorageService storageService;

    public AccountManager(StorageService storageService) {
        this.storageService = storageService;
    }

    //================================================================================================================//
    /* Primary-Methods                                                                                                 */
    //================================================================================================================//

    /**
     * Insert accountData to Database
     *
     * @param accountData
     * @return whether the operation was successful or not
     * @throws Exception
     */
    public boolean add(AccountData accountData) throws Exception{
        return storageService.add(accountData);
    }



    /**
     * Generate a  Salt out of random bytes.
     *
     * @return a String of random bytes.
     *
     */
    public static String getSalt()
            throws NoSuchAlgorithmException, NoSuchProviderException
    {
        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Create array for salt
        byte[] salt = new byte[16];

        // Get a random salt
        sr.nextBytes(salt);

        // return salt
        return Arrays.toString(salt);
    }


    /**
     *  Create a Password String from a String and a generated salt
     *
     * @param passwordToHash the password the user typed in
     * @param salt the randomly generated salt
     * @return a byte Array of the new Hash Value
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String hashString(String passwordToHash, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;

    }

    //================================================================================================================//
    /* Helper-Methods                                                                                                 */
    //================================================================================================================//


}
