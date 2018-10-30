package chatappWebApp.token;

import net.bytebuddy.utility.RandomString;

public class Generator {

    private String token;
    private static final int length = 10;

    public Generator() {
        token = RandomString.make(length);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
