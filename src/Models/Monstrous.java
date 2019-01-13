package Models;

public class Monstrous implements IRarity {

    private final static int CARDS[] = {0,0,0,0,0,0, 2, 4, 6, 10, 14, 20, 25, 30, 40, 50, 60, 80, 100, 120, 200, 320, 800};

    @Override
    public int[] getCards() {
        return CARDS;
    }

    @Override
    public int clanPointsCost(int lv) {
        if(lv >= 6 && lv < 12)
            return 200;
        else if(lv >=12 && lv < 23)
            return 400;
        else
            return 0;
    }
}

