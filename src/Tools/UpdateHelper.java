package Tools;

import Business.EnumRarity;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UpdateHelper {

    public static Map<String, Object> objectsToUpdate = new HashMap<>();

    private static Map<String, String> labelsMap= null;

    public static void initLabelsMap(){
        labelsMap = new HashMap<>();
        labelsMap.put("main.lvLabel",           "main.lvLabel");
        labelsMap.put("main.cardsLabel",        "main.cardsLabel");
        labelsMap.put("main.confirmButton",     "main.confirmButton");
        labelsMap.put("CPNeeded.mainLabel",     "CPNeeded.mainLabel");
        labelsMap.put("CPUpgreade.mainLabel",   "CPUpgreade.mainLabel");
        labelsMap.put("main.languages",         "main.language");
        labelsMap.put("tabs.tab1",              "tabs.tab1");
        labelsMap.put("tabs.tab2",              "tabs.tab2");
        labelsMap.put("tabs.tab3",              "tabs.tab3");
        labelsMap.put("main.stageHeader",       "main.stageHeader");

    }

    public static void updateLabels(){
        if(labelsMap == null){
            initLabelsMap();
        }
        List<String> keys = new ArrayList<>(objectsToUpdate.keySet());
        for(String k : keys){
            Object ob = objectsToUpdate.get(k);
            String msg = Messages.getMessage(labelsMap.get(k.substring(k.indexOf(".")+1)));
            if(ob instanceof Label){
                ((Label) ob).setText(msg);
            }
            else if(ob instanceof Button){
                ((Button) ob).setText(msg);
            }
            else if(ob instanceof ComboBox){
                ComboBox<String> comboBox = (ComboBox<String>)ob;
                comboBox.getItems().clear();
                comboBox.getItems().addAll(EnumRarity.getRarities());
                comboBox.getSelectionModel().selectFirst();
            }
        }
    }
}
