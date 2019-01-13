package Business;

import Models.IRarity;

public class CPNeededBusiness {
    private static String result;
    private static int cpNeeded;

    public static String calculateCPToTargetLv(int lv, int collectedCards, String rarity, int targetLv){
        clean();
        if(lv < 23 && targetLv <=23 && targetLv> lv)
        {
            calculateCPToTargetLv(lv,collectedCards, RarityBuilder.getRarity(rarity), targetLv,0);
        }
        else
        {
            result = "Nie możesz ulepszyć tego potwora.";
        }
        return result;
    }

    private static void calculateCPToTargetLv(int lv, int collectedCards, IRarity iRarity, int targetLv, int goldCost){
        if(lv < 23 && targetLv <=23 && targetLv> lv)
        {

            int[] cardsToUpgreade = iRarity.getCards();
            int cpCost = iRarity.clanPointsCost(lv);
            goldCost += GoldCosts.getGoldCosts(lv);
            if(collectedCards > cardsToUpgreade[lv])
            {
                lv++;
                collectedCards -= cardsToUpgreade[lv];
                if(lv == targetLv){
                    result = "Nie potrzebujesz CP żeby ulepszyć potwora do " + targetLv + " poziomu.\nKoszt: " + goldCost;
                    return;
                }
            }
            else
            {
                cpNeeded += (cardsToUpgreade[lv]- collectedCards) * cpCost;
                lv++;
                if(lv == targetLv)
                {
                    result = "Potrzebujesz " + cpNeeded + " CP żeby ulepszyć do " + targetLv + " poziomu.\nKoszt: " + goldCost;
                    return;
                }
            }
            calculateCPToTargetLv(lv,collectedCards,iRarity, targetLv, goldCost);
        }
    }
    private static  void clean(){
        result = "";
        cpNeeded= 0;
    }
}

