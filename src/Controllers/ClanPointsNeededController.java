package Controllers;

import Business.CPNeededBusiness;
import Tools.Messages;
import Tools.UpdateHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ClanPointsNeededController extends BaseController{


    @FXML
    public TextField targetLvTextField;
    @FXML
    public Label targetLvLabel;

    @Override
    public void initialize() {
        super.initialize();
        update();
        addObjectsToMap();
    }

    private void addObjectsToMap(){
        UpdateHelper.objectsToUpdate.put("tab3.main.lvLabel", lvLabel);
        UpdateHelper.objectsToUpdate.put("tab3.main.cardsLabel", cardsLabel);
        UpdateHelper.objectsToUpdate.put("tab3.main.confirmButton", confrimButton);
        UpdateHelper.objectsToUpdate.put("tab3.CPNeeded.mainLabel", targetLvLabel);
    }

    public void calculateCPToTargetLv(){
        if(correctLv() && validTargetLv())
        {
            resultLabel.setText(CPNeededBusiness.calculateCPToTargetLv(
                    Integer.valueOf(lvTextField.getText()),
                    Integer.valueOf(cardsTextField.getText()),
                    rarityComboBox.getSelectionModel().getSelectedItem(),
                    Integer.valueOf(targetLvTextField.getText())
            ));
        }
        else
        {
            resultLabel.setText(Messages.getMessage("main.wrongLv"));
        }
    }

    private boolean validTargetLv(){
        int targetlv = Integer.valueOf(targetLvTextField.getText());
        return targetlv > 1 &&  targetlv <= 23;
    }

//    @Override
//    public void update(){
//        super.update();
//        targetLvLabel.setText();
//    }
}
