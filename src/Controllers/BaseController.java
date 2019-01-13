package Controllers;

import Business.EnumRarity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

abstract public class BaseController {

    @FXML
    public Label lvLabel;
    @FXML
    // public NumberTextField lvTextField;
    public TextField lvTextField;
    @FXML
    public Label cardsLabel;
    @FXML
    // public NumberTextField cardsTextField;
    public TextField cardsTextField;
    @FXML
    public ComboBox<String> rarityComboBox ;
    @FXML
    public Button confrimButton;
    @FXML
    public Label resultLabel;

    public String WRONG_LV ="Podaj poprawny poziom!";

    boolean correctLv(){
        int MAX_LV = 23;
        int currentLv = Integer.valueOf(lvTextField.getText());
        String rarity = rarityComboBox.getSelectionModel().getSelectedItem();
        return rarity.equals(EnumRarity.Legendary.getName()) && currentLv >= 9 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Monstrous.getName()) && currentLv >= 6 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Epic.getName()) && currentLv >= 3 && currentLv <= MAX_LV
                || rarity.equals(EnumRarity.Common.getName()) && currentLv >= 1 && currentLv <= MAX_LV;
    }
    public void initialize(){
        rarityComboBox.getItems().addAll(EnumRarity.getRarities());
        rarityComboBox.getSelectionModel().selectFirst();
        lvLabel.setText("Poziom:");
        cardsLabel.setText("Ilość kart:");
    }
}
