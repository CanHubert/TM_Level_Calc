package Models;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Msg {
    public static Locale[] locale;
    public static ResourceBundle labels;

    public void setLocale(){
        locale = new Locale[2];
        locale[0] = Locale.ROOT;
        locale[1] = Locale.ENGLISH;
    }

    public static List<String> getLanguages(){
        return Stream.of(locale).map(Locale::getDisplayLanguage).collect(Collectors.toList());
    }

    public static void initResources(){
        labels = ResourceBundle.getBundle("messages", locale[0]);
    }

    public static String convert(String key){
        String text = labels.getString(key);

        text =text.replace("", "ś");
        text =text.replace("æ", "ć");
        return text;
    }
}
