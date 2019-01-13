package Models;

public class Common implements IRarity {
    private final static int CARDS[] = {
            0,2,4,10,20,40,80,140,200,280,360,460,560,700,1000,1300,1600,2000,2500,3000,5000,8000,20000};

    @Override
    public int[] getCards() {
        return CARDS;
    }

    @Override
    public int clanPointsCost(int lv) {
        if(lv >= 1 && lv < 12)
            return 2;
        else if(lv >=12 && lv < 23)
            return 4;
        else
            return 0;
    }
}
