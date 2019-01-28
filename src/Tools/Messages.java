package Tools;


import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author petr.nadeiko
 *
 * Singleton
 */
public class Messages implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -631411329506671388L;

    private static Messages instance = null;
    private static ResourceBundle messages;
    private static Locale locale;
    private static Map<Character, Character> sigsnMap = null;

    protected Messages(String local) {

        locale = new Locale(local.toLowerCase(), local.toUpperCase());
        initMessages();
    }

    protected Messages(Locale loc) {

        locale = loc;
        initMessages();
    }

    private static void initMessages() {

        try
        {
            messages = ResourceBundle.getBundle("messages", getLocale());
        }
        catch (MissingResourceException e)
        {
            locale = new Locale("pl", "PL");
            messages = ResourceBundle.getBundle("messages", locale);
        }
    }

    public static Messages getInstance(String local) {
        if (instance == null) {
            instance = new Messages(local);
        }
        return instance;
    }

    public static Messages getInstance(Locale locale) {
        if (instance == null) {
            instance = new Messages(locale);
        }
        return instance;
    }

    public static String getMessage(String key)
    {
        try
        {
            if (messages == null)
            {
                initMessages();
            }
            return convert(messages.getString(key));
        }
        catch (Exception ex)
        {
            return key;
        }
    }

    public static String getAllRows(String key, int size)
    {
        String[] s = Messages.getMessage(key).split(",");
        if(Integer.parseInt(s[s.length - 1]) >= size)
        {
            return s[s.length - 1];
        }
        else
        {
            return String.valueOf(size);
        }
    }

    public static String getAllRowsTemplate(String key, int size)
    {
        String message = Messages.getMessage(key);
        String[] s = message.split(",");

        if(Integer.parseInt(s[s.length - 1]) >= size)
        {
            return message;
        }
        else
        {
            return message + "," + size;
        }
    }

    public static void setMessageParams(String bundleName, String localeName) {
        messages = ResourceBundle.getBundle(bundleName, new Locale(localeName.toLowerCase(), localeName.toUpperCase()));
    }

    public static void setMessageParams(String bundleName, Locale locale) {
        messages = ResourceBundle.getBundle(bundleName, locale);
    }

    public static Locale getLocale() {

        if (locale == null)
        {
            locale = new Locale("pl", "PL");
        }

        return locale;
    }

    public static void setLocale(Locale loc){
        locale = loc;
    }

    private static String convert(String text){

        if(locale.getLanguage().equals("pl")){
            if(sigsnMap == null)
            {
                sigsnMap = getPolishSignsMap();
            }
        }
       for(Character k : sigsnMap.keySet())
       {
           text= text.replace(k, sigsnMap.get(k));
       }
       return text;
    }

    private static Map<Character,Character> getPolishSignsMap(){
        sigsnMap = new HashMap<>();
        sigsnMap.put('', 'ś');
        sigsnMap.put('æ', 'ć');
        sigsnMap.put('³', 'ł');

        return sigsnMap;
    }
}
