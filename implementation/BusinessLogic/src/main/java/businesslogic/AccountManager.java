package businesslogic;

import datarecords.AccountData;
import persistence.StorageService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

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

        String[] options = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                            "@", "#", "%", "^", "&", "*", "(", ")", "-", "_", "|", "!",};

        StringBuilder returner = null;
        for (int i = 0; i < 12; i++){
            int min = 0;
            int max = options.length - 1;
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

            String c = options[random_int];

            returner = (returner == null ? new StringBuilder() : returner).append(c);
        }

        return String.valueOf(returner);
//
//        // Always use a SecureRandom generator
//        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
//
//        // Create array for salt
//        byte[] salt = new byte[16];
//
//        // Get a random salt
//        sr.nextBytes(salt);
//
//        // return salt
//        return Arrays.toString(salt);
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
