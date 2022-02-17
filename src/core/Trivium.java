package core;

import java.sql.SQLOutput;

public class Trivium {


    LFSR93 Lfsr93;
    LFSR84 Lfsr84;
    LFSR111 Lfsr111;

    public Trivium() {
        this.Lfsr93 = new LFSR93(LfsrMaker(93));
        this.Lfsr84 = new LFSR84(LfsrMaker(84));
        this.Lfsr111 = new LFSR111(LfsrMaker(111));
    }

    public int[] LfsrMaker(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;
        }
        return result;
    }

    public void run(int steps){
        warmup();
        for(int i = 0; i < steps; i++){
            step();
        }
    }

    public void warmup(){
        int warpUpRounds = 10;
        for(int i = 0; i < warpUpRounds; i++){
            step();
        }
    }

    public void step(){
        int end93 = Lfsr93.endBit();
        int end84 = Lfsr84.endBit();
        int end111 = Lfsr111.endBit();


    }

    private String listPrinter(int[] list){
        String result = "[";
        for (int i = 0; i < list.length; i++){
            if(i == 0){
                result = result + String.valueOf(list[i]);
            }
            else{
                result = result + ", " + String.valueOf(list[i]);
            }
        }
        result = result + "]";
        return result;

    }

}
