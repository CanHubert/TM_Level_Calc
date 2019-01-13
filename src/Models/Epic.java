package Models;

public class Epic implements IRarity {

    private final static int CARDS[] = {
            0,0,0,2,4,10,20,40,50,70,90,120,140,180,250,350,400,500,600,800,1300,2100,5200};

    @Override
    public int[] getCards(){
        return CARDS;
    }

    @Override
    public int clanPointsCost(int lv) {
        if(lv >= 3 && lv < 12)
            return 20;
        else if(lv >=12 && lv < 23)
            return 40;
        else
            return 0;
    }
}


