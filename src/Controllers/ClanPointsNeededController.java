package Controllers;

import Business.CPNeededBusiness;
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
        targetLvLabel.setText("Podaj docelowy poziom potwora.");
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
            resultLabel.setText(WRONG_LV);
        }
    }

    private boolean validTargetLv(){
        int targetlv = Integer.valueOf(targetLvTextField.getText());
        return targetlv > 1 &&  targetlv <= 23;

    }
}
