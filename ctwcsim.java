public class ctwcsim {
    public static void main(String[] args) {
        //competitor's ratings
        int[][] elo = { { 1, 1875, 0 }, { 2, 1917, 0 }, { 3, 1766, 0 }, { 4, 1712, 0 }, { 5, 1678, 0 }, { 6, 1709, 0 },
                { 7, 1661, 0 }, { 8, 1601, 0 } }; 
        // restoring the same ratings because I'm inefficent
        int[][] bracket = new int[4][2];
        bracket[0][0] = elo[0][1];
        bracket[1][0] = elo[1][1];
        bracket[2][0] = elo[2][1];
        bracket[3][0] = elo[3][1];
        bracket[3][1] = elo[4][1];
        bracket[2][1] = elo[5][1];
        bracket[1][1] = elo[6][1];
        bracket[0][1] = elo[7][1];
        for (int j = 0; j < 10000000; j++) { //10 million simulations
            //keeping track of where they go in the bracket
            int winner = 0;
            int wOne = 0;
            int lOne = 0;
            int wTwo = 0;
            int lTwo = 0;
            int wThree = 0;
            int lThree = 0;
            int wFour = 0;
            int lFour = 0;
            int wFive = 0;
            int wSix = 0;
            int wSeven = 0;
            int lSeven = 0;
            int wEight = 0;
            int lEight = 0;
            int wNine = 0;
            int wTen = 0;
            int wEleven = 0;
            int lEleven = 0;
            int wTwelve = 0;
            int wThirteen = 0;
            int wFourteen = 0;
            int lFourteen = 0;

            //Simulating the actual bracket
            for (int i = 0; i <= 14; i++) {
                if (i == 0) {
                    //If the first match up, check to see who randomly wins against their predicted win chance
                    if (Math.random() < eloOdds(bracket[0][0], bracket[0][1])) {
                        //then progress in the bracket
                        wOne = bracket[0][0];
                        lOne = bracket[0][1];
                    } else {
                        wOne = bracket[0][1];
                        lOne = bracket[0][0];
                    }
                } else if (i == 1) {
                    if (Math.random() < eloOdds(bracket[1][0], bracket[1][1])) {
                        wTwo = bracket[1][0];
                        lTwo = bracket[1][1];
                    } else {
                        wTwo = bracket[1][1];
                        lTwo = bracket[1][0];
                    }
                } else if (i == 2) {
                    if (Math.random() < eloOdds(bracket[2][0], bracket[2][1])) {
                        wThree = bracket[2][0];
                        lThree = bracket[2][1];
                    } else {
                        wThree = bracket[2][1];
                        lThree = bracket[2][0];
                    }
                } else if (i == 3) {
                    if (Math.random() < eloOdds(bracket[3][0], bracket[3][1])) {
                        wFour = bracket[3][0];
                        lFour = bracket[3][1];
                    } else {
                        wFour = bracket[3][1];
                        lFour = bracket[3][0];
                    }
                } else if (i == 4) {
                    if (Math.random() < eloOdds(lOne, lTwo)) {
                        wFive = lOne;
                        // lFive = lTwo;
                    } else {
                        wFive = lTwo;
                        // lFive = lOne;
                    }
                } else if (i == 5) {
                    if (Math.random() < eloOdds(lThree, lFour)) {
                        wSix = lThree;
                        // lSix = lFour;
                    } else {
                        wSix = lFour;
                        // lSix = lThree;
                    }
                } else if (i == 6) {
                    if (Math.random() < eloOdds(wOne, wTwo)) {
                        wSeven = wOne;
                        lSeven = wTwo;
                    } else {
                        wSeven = wTwo;
                        lSeven = wOne;
                    }
                } else if (i == 7) {
                    if (Math.random() < eloOdds(wThree, wFour)) {
                        wEight = wThree;
                        lEight = wFour;
                    } else {
                        wEight = wFour;
                        lEight = wThree;
                    }
                } else if (i == 8) {
                    if (Math.random() < eloOdds(lEight, wFive)) {
                        wNine = lEight;
                    } else {
                        wNine = wFive;
                    }
                } else if (i == 9) {
                    if (Math.random() < eloOdds(lSeven, wSix)) {
                        wTen = lSeven;
                    } else {
                        wTen = wSix;
                    }
                } else if (i == 10) {
                    if (Math.random() < eloOdds(wSeven, wEight)) {
                        wEleven = wSeven;
                        lEleven = wEight;
                    } else {
                        wEleven = wEight;
                        lEleven = wSeven;
                    }
                } else if (i == 11) {
                    if (Math.random() < eloOdds(wNine, wTen)) {
                        wTwelve = wNine;
                    } else {
                        wTwelve = wTen;
                    }
                } else if (i == 12) {
                    if (Math.random() < eloOdds(lEleven, wTwelve)) {
                        wThirteen = lEleven;
                    } else {
                        wThirteen = wTwelve;
                    }
                } else if (i == 13) {
                    if (Math.random() < eloOdds(wEleven, wThirteen)) {
                        winner = wEleven;
                        i = 16;
                    } else {
                        wFourteen = wThirteen;
                        lFourteen = wEleven;
                    }
                } else if (i == 14) {
                    if (Math.random() < eloOdds(wFourteen, lFourteen)) {
                        winner = wFourteen;
                    } else {
                        winner = lFourteen;
                    }
                }
            }
            //crediting the winner of the bracket, again inefficently
            for (int k = 0; k < 8; k++) {
                if (winner == elo[k][1]) {
                    elo[k][2]++;
                }
            }

        }
        //printing out the results
        for (int l = 0; l < 8; l++) {
            float prop = (float) elo[l][2] / 100000;
            int ll = l + 1;
            System.out.println(ll + " seed has " + prop + "% chance of winning.");
        }

    }

    //calculates odds of who wins each individual matchup
    public static double eloOdds(int pro, int opp) {
        double top = pro;
        double bot = opp;
        double p = 1 / (1 + (Math.pow(10, ((bot - top) / 400))));
        double odds = (Math.pow(p, 3)) * (10 - (15 * p) + (6 * (Math.pow(p, 2))));
        return (odds);
    };
}