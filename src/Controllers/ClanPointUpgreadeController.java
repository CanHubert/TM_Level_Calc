package Controllers;

import Tools.Messages;
import Tools.UpdateHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import Business.CPUpgreadeBusiness;


public class ClanPointUpgreadeController extends BaseController{


    @FXML
    public Label clanPointsLabel;
    @FXML
    public TextField clanPointsTextField;

    @Override
    public void initialize() {
        update();
        clanPointsTextField.setText("0");
        addObjectsToMap();
    }

    private void addObjectsToMap(){
        UpdateHelper.objectsToUpdate.put("tab2.main.lvLabel", lvLabel);
        UpdateHelper.objectsToUpdate.put("tab2.main.cardsLabel", cardsLabel);
        UpdateHelper.objectsToUpdate.put("tab2.main.confirmButton", confrimButton);
        UpdateHelper.objectsToUpdate.put("tab2.CPUpgreade.mainLabel", clanPointsLabel);
        UpdateHelper.objectsToUpdate.put("tab2.rarityComboBox", rarityComboBox);

    }

    public void calculateCPUpgreade(){
        if(correctLv())
        {
            resultLabel.setText(CPUpgreadeBusiness.upgreadeUsingCP(Integer.valueOf(lvTextField.getText()),
                    Integer.valueOf(cardsTextField.getText()),
                    rarityComboBox.getSelectionModel().getSelectedItem(),
                    Integer.valueOf(clanPointsTextField.getText())));
        }
        else
        {
            resultLabel.setText(Messages.getMessage("tab2.main.wrongLv"));
        }
        resultLabel.setStyle(Messages.getMessage("css.resultStyle"));
    }


}
