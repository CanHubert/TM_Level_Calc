package Controllers;

import Tools.Messages;
import Tools.UpdateHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class TabsView {
    @FXML
    public Tab tab1;
    @FXML
    public Tab tab2;
    @FXML
    public Tab tab3;

    public void initialize(){

        tab1.setText(Messages.getMessage("tabs.tab1"));
        tab2.setText(Messages.getMessage("tabs.tab2"));
        tab3.setText(Messages.getMessage("tabs.tab3"));
        addObjectsToMap();
    }

    private void addObjectsToMap(){
        UpdateHelper.objectsToUpdate.put("tabs.tab1", tab1);
        UpdateHelper.objectsToUpdate.put("tabs.tab2", tab2);
        UpdateHelper.objectsToUpdate.put("tabs.tab3", tab3);
    }
}
