package Controllers;

import Business.App;



public class MainController extends BaseController{

    public void calculateMonsterLevel(){
        if (correctLv())
            resultLabel.setText(App.possibleLv(Integer.valueOf(lvTextField.getText()),
                    Integer.valueOf(cardsTextField.getText()),
                    rarityComboBox.getSelectionModel().getSelectedItem()));
        else
            resultLabel.setText(WRONG_LV);
    }
}
