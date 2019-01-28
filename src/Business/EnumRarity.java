package Business;

import Tools.Messages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumRarity {
    Common("common"),
    Epic("epic"),
    Monstrous("monstrous"),
    Legendary("legendary");

    String name;

    EnumRarity(String name){
        this.name = name;
    }

    static public List<String> getRarities(){
        return Stream.of(EnumRarity.values()).map(EnumRarity::getLabel).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getLabel(){
        return Messages.getMessage("rarities."+ name);
    }
}
