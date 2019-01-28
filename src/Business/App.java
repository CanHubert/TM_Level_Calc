package Business;

public class App {
    static private int SUMA = 0;
    static private int LV_INCOME = 0;
    static private int STARTING_LV = 0;
    static public String result;
    public static void main(String[] args) {

       // possibleLv(Integer.valueOf(args[0]), Integer.valueOf(args[1]), args[2]);
//        possibleLv(15,63,"purple");
//        possibleLv(15,77,"purple");
//        possibleLv(17,96,"purple");
//        possibleLv(14,133,"purple");
//        possibleLv(12,37,"purple");
//        possibleLv(12,103,"purple");

//        possibleLv(17,794, "epic");
//        possibleLv(17,804, "epic");
//        possibleLv(17,1283, "epic");
//        possibleLv(14,762, "epic");

//        possibleLv(14,556, "epic");
//        possibleLv(14,1198, "epic");
//        possibleLv(12,1501, "epic");
//        possibleLv(12,942, "epic");

//        possibleLv(19,3546, "common");
//        possibleLv(18,2838, "common");
//        possibleLv(18,3588, "common");
//        possibleLv(15,2730, "common");
//        possibleLv(15,5144, "common");
//        possibleLv(15,3386, "common");
//        possibleLv(15,6594, "common");
//        possibleLv(15,6539, "common");
//        possibleLv(15,2035, "common");
//        possibleLv(14,2674, "common");
//        possibleLv(12,1669, "common");
//        possibleLv(12,54, "l");
//
//
//        System.out.println("łączny koszt: " + SUMA);
//        System.out.println("łączny przyrost poziomów: " + LV_INCOME);


    }

    static public String possibleLv(int lv, int collectedCards, EnumRarity rarity){
        STARTING_LV = lv;



        if(lv < 23)
        {
            int[] CARDS = RarityBuilder.getRarity(rarity).getCards();
            if(collectedCards >= CARDS[lv])
            {
                collectedCards-=CARDS[lv];
                possibleLv(++lv, collectedCards, rarity,0);
            }
            else
            {
                result = "Poziom " + lv + "\n" + (collectedCards)+ "/" + CARDS[lv] + " ";
            }
        }
        else
        {
            result = "Poziom 23\n" + (collectedCards) + "/MAX";
        }

        return result;
    }

    static private void possibleLv(int lv, int collectedCards, EnumRarity rarity, int goldCosts){

        if(lv < 23)
        {
            int[] CARDS = RarityBuilder.getRarity(rarity).getCards();
            goldCosts += GoldCosts.getGoldCosts(lv);

            if (collectedCards >= CARDS[lv])
            {
                collectedCards -= CARDS[lv];
                possibleLv(++lv, collectedCards, rarity, goldCosts);
            }
            else
            {
                result = "Poziom " + lv + "\n" + (collectedCards) + "/" + CARDS[lv] + "\n" + "Koszt: " + goldCosts;
                SUMA += goldCosts;
                LV_INCOME += (lv - STARTING_LV);
            }
        }
        else
        {
            goldCosts+=200000;
            result = "Poziom 23\n" + (collectedCards) + "/MAX" + "\n" + "Koszt: " + goldCosts;
        }
    }

//    static public String possibleLv(int lv, int collectedCards, String rarity){
//        STARTING_LV = lv;
//        int[] CARDS = RarityBuilder.getRarity(rarity).getCards();
//        if(collectedCards >= CARDS[lv])
//        {
//            collectedCards-=CARDS[lv];
//            return possibleLv(++lv, collectedCards, rarity,0);
//        }
//
//        double percent = ((double) collectedCards / (double) CARDS[lv]) *100;
//        return "Poziom " + lv + " " + (collectedCards)+ "/" + CARDS[lv] + " " + percent+"%";
//    }
//
//    static private String possibleLv(int lv, int collectedCards, String rarity, int goldCosts){
//
//        int[] CARDS = RarityBuilder.getRarity(rarity).getCards();
//        goldCosts += GoldCosts.getGoldCosts(lv);
//        if(collectedCards >= CARDS[lv])
//        {
//            collectedCards-=CARDS[lv];
//            possibleLv(++lv, collectedCards, rarity, goldCosts);
//        }
//
//        double percent = ((double) collectedCards / (double) CARDS[lv]) *100;
//        return ("Poziom " + lv + " " + (collectedCards)+ "/" + CARDS[lv] + " " + percent+"% " + " Koszt: "+ goldCosts);
//
//    }
}
