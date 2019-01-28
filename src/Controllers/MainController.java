package Controllers;

import Business.App;
import Business.EnumRarity;
import Tools.Messages;
import Tools.UpdateHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Locale;

public class MainController extends BaseController{

    @FXML
    public Button languages;

    public void initialize(){
        super.update();
        languages.setText(Messages.getMessage("main.language"));
       addObjectsToMap();
    }

    public void calculateMonsterLevel(){
        if (correctLv())
            resultLabel.setText(App.possibleLv(Integer.valueOf(lvTextField.getText()),
                    Integer.valueOf(cardsTextField.getText()),
                    rarityComboBox.getSelectionModel().getSelectedItem()));
        else
            resultLabel.setText(Messages.getMessage("main.wrongLv"));
    }

    private void addObjectsToMap(){
        UpdateHelper.objectsToUpdate.put("tab1.main.lvLabel", lvLabel);
        UpdateHelper.objectsToUpdate.put("tab1.main.cardsLabel", cardsLabel);
        UpdateHelper.objectsToUpdate.put("tab1.main.confirmButton", confrimButton);
        UpdateHelper.objectsToUpdate.put("tab1.main.languages", languages);
        UpdateHelper.objectsToUpdate.put("tab1.rarityComboBox", rarityComboBox);
    }

    public void onSelect(){
        String language = Messages.getLocale().getLanguage();
        if(language.equals("pl"))
        {
            Messages.setLocale(new Locale("en", "EN"));
            Messages.setMessageParams("messages", Messages.getLocale());
        }
        else if(language.equals("en"))
        {
            Messages.setLocale(new Locale("pl", "PL"));
            Messages.setMessageParams("messages", Messages.getLocale());
        }
        UpdateHelper.updateLabels();
    }
}
