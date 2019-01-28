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
        labelsMap.put("main.lvLabel", Messages.getMessage("main.lvLabel"));
        labelsMap.put("main.cardsLabel", Messages.getMessage("main.cardsLabel"));
        labelsMap.put("main.confirmButton", Messages.getMessage("main.confirmButton"));
        labelsMap.put("CPNeeded.mainLabel", Messages.getMessage("CPNeeded.mainLabel"));
        labelsMap.put("CPUpgreade.mainLabel", Messages.getMessage("CPUpgreade.mainLabel"));
        labelsMap.put("main.language", Messages.getMessage("main.language"));
        labelsMap.put("tabs.tab1", Messages.getMessage("tabs.tab1"));
        labelsMap.put("tabs.tab2", Messages.getMessage("tabs.tab2"));
        labelsMap.put("tabs.tab3", Messages.getMessage("tabs.tab3"));
        labelsMap.put("main.stageHeader", Messages.getMessage("main.stageHeader"));

    }

    public static void updateLabels(){
        if(labelsMap == null){
            initLabelsMap();
        }
        List<String> keys = new ArrayList<>(objectsToUpdate.keySet());
        for(String k : keys){
            Object ob = objectsToUpdate.get(k);
            String msg = labelsMap.get(k.substring(k.indexOf(".")+1));
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
