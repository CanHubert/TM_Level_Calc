package Controllers;

import Business.App;
import Business.EnumRarity;
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
        super.initialize();
        clanPointsLabel.setText("Zebrane CP:");
        clanPointsTextField.setText("0");
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
            resultLabel.setText(WRONG_LV);
        }
    }
}
