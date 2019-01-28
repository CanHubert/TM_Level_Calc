import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
       String text = "main.tab1.upgrage";

       text= text.substring(text.indexOf(".")+1);
        System.out.println(text);
}

}
