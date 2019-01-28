package Business;

import Models.*;

public class RarityBuilder {

    static public IRarity getRarity(EnumRarity rarity){
        switch (rarity){
            case Epic: return new Epic();
            case Common: return new Common();
            case Legendary: return new Legendary();
            case Monstrous: return new Monstrous();
            default: return null;
        }
    }
}
