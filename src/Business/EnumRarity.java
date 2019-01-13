package Business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumRarity {
    Common("Zwykły"),
    Epic("Epicki"),
    Monstrous("Monstrualny"),
    Legendary("Legendarny");

    String name;

    EnumRarity(String name){
        this.name = name;
    }

    static public List<String> getRarities(){
        return Stream.of(EnumRarity.values()).map(e-> e.name).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
