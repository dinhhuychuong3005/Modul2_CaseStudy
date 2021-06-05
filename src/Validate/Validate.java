package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public final static String ID_REGEX ="^[E][M][P][0-9]{3}$";
    public final static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    public static final String PHONE_REGEX = "^[0][0-9]{9}$";


    public static boolean valid(String str,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
