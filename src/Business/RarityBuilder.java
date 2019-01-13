package Business;

import Models.*;

public class RarityBuilder {

    static public IRarity getRarity(String name){
        switch (name){
            case "Epicki" : return new Epic();
            case "Zwykły" : return new Common();
            case "Legendarny" : return new Legendary();
            case "Monstrualny" : return new Monstrous();
            default: return null;
        }
    }
}
