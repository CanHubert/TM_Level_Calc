package Models;

public class Legendary implements IRarity {

    private final static int CARDS[] = {0,0,0,0,0,0,0,0,0,2,4,6,8,10,12,14,16,20,22,25,45,80,200};

    @Override
    public int[] getCards() {
        return CARDS;
    }

    @Override
    public int clanPointsCost(int lv) {
        if(lv >= 9 && lv < 12)
            return 1200;
        else if(lv >=12 && lv < 23)
            return 1600;
        else
            return 0;
    }
}
