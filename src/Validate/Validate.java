package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public final static String ID_REGEX ="^[E][M][P][0-9]{3}$";
    public final static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    public static final String PHONE_REGEX = "^[0][0-9]{9}$";
    public static final String VNM_REGEX = "^[V][N][M][0-9]{3}$";
    public static final String DL_REGEX = "^[D][L][0-9]{3}$";
    public static final String NTF_REGEX = "^[N][T][F][0-9]{3}$";
    public static final String USERNAME_REGEX = "^[a-z0-9_-]{6,12}$";
    public static final String PASSWORD_REGEX = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})$";
    public static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean valid(String str,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
