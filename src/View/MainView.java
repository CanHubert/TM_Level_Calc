package View;

import Tools.Messages;
import Tools.UpdateHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class MainView extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        String prefix = "../View/";
        String mainView = "main.fxml";
        String tabsView = "tabsView.fxml";
        String needed = "cpNeeded2.fxml";
        Parent root = null;
        try
        {
             root = FXMLLoader.load(getClass().getResource(tabsView));
        }
        catch (NullPointerException e){
            saveToFile2(e.getMessage());

            return;
        }


        primaryStage.setTitle(Messages.getMessage("main.stageHeader"));
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
        UpdateHelper.objectsToUpdate.put("stageHeader", primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    static private void saveToFile2(String message) {
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter("log2.txt");
            fileWriter.write(message);
        }catch (Exception e){
            e.getStackTrace();
        }
        finally {
            try {
                if(fileWriter != null)
                {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
