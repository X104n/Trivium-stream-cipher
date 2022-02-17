package core;

import java.sql.SQLOutput;

public class Trivium {


    LFSR93 Lfsr93;
    LFSR84 Lfsr84;
    LFSR111 Lfsr111;
    String stream;

    public Trivium() {
        this.Lfsr93 = new LFSR93(Lfsr93Maker());
        this.Lfsr84 = new LFSR84(Lfsr84Maker());
        this.Lfsr111 = new LFSR111(Lfsr111Maker());
        this.stream = "";
    }

    public int[] Lfsr93Maker() {
        int[] key = keyMaker();
        int[] result = new int[93];
        for(int i = 0; i < 93; i++){
            if(i < key.length){
                result[i] = key[i];
            }
            else{
                result[i] = 0;
            }
        }

        return result;
    }

    public int[] Lfsr84Maker(){
        int[] IV = IVMaker();
        int[] result = new int[84];
        for(int i = 0; i < 84; i++){
            if(i < IV.length){
                result[i] = IV[i];
            }
            else{
                result[i] = 0;
            }
        }

        return result;
    }

    public int[] Lfsr111Maker(){
        int[] result = new int[111];
        for (int i = 0; i < 111; i++) {
            result[i] = 0;
        }
        result[110] = 1;
        result[109] = 1;
        result[108] = 1;
        return result;
    }

    public int[] keyMaker(){
        int[] result = new int[80];
        for(int i = 0; i < 80; i++){
            result[i] = 1;
        }
        return result;
    }

    public int[] IVMaker(){
        int[] result = new int[80];
        for(int i = 0; i < 80; i++){
            result[i] = 0;
        }
        return result;
    }

    public String getStream(){
        return stream;
    }

    public void run(int steps){
        warmup();
        for(int i = 0; i < steps; i++){
            stream = stream + String.valueOf(step());
        }
    }

    public void warmup(){
        int warpUpRounds = 1152;
        for(int i = 0; i < warpUpRounds; i++){
            step();
        }
    }

    public int step(){
        int end93 = Lfsr93.endBit();
        int end84 = Lfsr84.endBit();
        int end111 = Lfsr111.endBit();

        int start93 = Lfsr93.startBit(end111);
        int start84 = Lfsr84.startBit(end93);
        int start111 = Lfsr111.startBit(end84);

        int firstXor = Operations.bitXOR(end93, end84);
        int bitStream = Operations.bitXOR(firstXor, end111);

        Lfsr93.step();
        Lfsr84.step();
        Lfsr111.step();

        return bitStream;

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
