package datarecords;

public class AccountData {

    private final String firstname;
    private final String lastname;
    private final String position;
    private final String salt;
    private final String eMail;
    private final String passwordHash;

    public AccountData(String firstname, String lastname, String position,
                       String salt, String eMail, String passwordHash) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.salt = salt;
        this.eMail = eMail;
        this.passwordHash = passwordHash;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    public String getSalt() {
        return salt;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
