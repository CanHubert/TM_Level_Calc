package Business;

public class GoldCosts {
    private static int[] GOLD ={
                0,
                5,
                10,
                30,
                70,
                150,
                350,
                700,
                1000,
                1600,
                2500,
                3600,
                5000,
                7000,
                10000,
                15000,
                22000,
                32000,
                45000,
                60000,
                80000,
                100000,
                200000,

    };

    public static int getGoldCosts(int lv){
        if(lv < 1) return 0;
        return GOLD[lv-1];
    }
}



