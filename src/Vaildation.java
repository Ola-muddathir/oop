
import java.util.Scanner;



public abstract class Vaildation {
    public Vaildation() {}

    public abstract boolean login();

    public boolean vaildemail(String VaildEmail) {
        int atSymbolIndex = VaildEmail.indexOf('@');
        if (atSymbolIndex == -1 || VaildEmail.indexOf('@', atSymbolIndex + 1) != -1) {
            return false;
        }
        String localPart = VaildEmail.substring(0, atSymbolIndex);
        String domainPart = VaildEmail.substring(atSymbolIndex + 1);
        int dotIndex = domainPart.indexOf('.');
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == domainPart.length() - 1) {
            return false;
        }
        return true;

    }
}