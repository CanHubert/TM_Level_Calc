package Controllers;

import Business.EnumRarity;
import Models.NumberTextField;
import Tools.Messages;
import Tools.UpdateHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class BaseController {

    @FXML
    public Label lvLabel;
    @FXML
     public NumberTextField lvTextField;
   // public TextField lvTextField;
    @FXML
    public Label cardsLabel;
    @FXML
     public NumberTextField cardsTextField;
   // public TextField cardsTextField;
    @FXML
    public ComboBox<EnumRarity> rarityComboBox ;
    @FXML
    public Button confrimButton;
    @FXML
    public Label resultLabel;


    boolean correctLv(){
        int MAX_LV = 23;
        int currentLv = Integer.valueOf(lvTextField.getText());
        EnumRarity rarity = rarityComboBox.getSelectionModel().getSelectedItem();
        return rarity.equals(EnumRarity.Legendary) && currentLv >= 9 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Monstrous) && currentLv >= 6 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Epic) && currentLv >= 3 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Common) && currentLv >= 1 && currentLv <= MAX_LV;
    }
    public void initialize(){

    }

    public void update(){
        lvLabel.setText(Messages.getMessage("main.lvLabel"));
        cardsLabel.setText(Messages.getMessage("main.cardsLabel"));
        confrimButton.setText(Messages.getMessage("main.confirmButton"));
        rarityComboBox.getItems().clear();
        rarityComboBox.getItems().addAll(EnumRarity.values());
        rarityComboBox.getSelectionModel().selectFirst();
    }
}
