package Business;

import Models.IRarity;

public class CPUpgreadeBusiness {
    private static  String result;
    private static int cpUsed =0;

    public static String upgreadeUsingCP(int lv, int collectedCards, String rarity, int cpCollected){
        cpUsed=0;
        if(lv < 23)
        {
            IRarity iRarity = RarityBuilder.getRarity(rarity);
            int cardsToUpgreade[] = iRarity.getCards();
            int CPNeededToUpgreade = (cardsToUpgreade[lv] - collectedCards) * iRarity.clanPointsCost(lv);

            if (collectedCards >= cardsToUpgreade[lv]) {
                collectedCards -= cardsToUpgreade[lv];

            }
            else if (CPNeededToUpgreade < cpCollected)
            {
                cpCollected -= CPNeededToUpgreade;
                cpUsed += CPNeededToUpgreade;
            }

            upgreadeUsingCP(++lv, collectedCards, iRarity, cpCollected, 0);
        }
        else
        {
            result = "Nie musisz ulepszać bardziej tego potwora :).";
        }

        return result;
    }

    private static void upgreadeUsingCP(int lv,  int cardsCollected ,IRarity iRarity, int cpCollected, int goldCost){
        int cardsToLvUp = iRarity.getCards()[lv];
        int cpCost = iRarity.clanPointsCost(lv);
        int CPNeededToUpgreade =  cardsToLvUp* cpCost;
        if(cardsCollected >= cardsToLvUp){
            cardsCollected -= cardsToLvUp;
        }
        else if((cardsToLvUp - cardsCollected) * cpCost <= cpCollected)
        {
            cardsCollected = 0;
            cpUsed += CPNeededToUpgreade;
            cpCollected -= CPNeededToUpgreade;
        }
        else
        {
            result = "Poziom: " + lv +"\nUżyte CP: " + cpUsed + "\nPozostało CP: " + cpCollected + "\n" + "Koszt: " + goldCost+ "\n";
            return;
        }
        goldCost += GoldCosts.getGoldCosts(lv);
        upgreadeUsingCP(++lv, cardsCollected, iRarity, cpCollected, goldCost );
    }

    public static void main(String[] args) {
        System.out.println(upgreadeUsingCP(15,14,"Legendarny", 178000));
        System.out.println(upgreadeUsingCP(9,100,"Legendarny", 0));
        System.out.println(upgreadeUsingCP(20,132,"Monstrualny", 155200));
    }
}
