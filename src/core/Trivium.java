package core;

import java.util.ArrayList;

public class Trivium {

    private final LFSR93 Lfsr93;
    private final LFSR84 Lfsr84;
    private final LFSR111 Lfsr111;
    private final ArrayList<Integer> streamArray;

    /**
     * Making a new Trivium stream cipher.
     * @param IV The IV we use for the LFSR93
     * @param key The Key we use for the LFSR84
     */
    public Trivium(int[] IV, int[] key) {
        this.Lfsr93 = new LFSR93(lfsr93Maker(IV));
        this.Lfsr84 = new LFSR84(lfsr84Maker(key));
        this.Lfsr111 = new LFSR111(lfsr111Maker());
        this.streamArray = new ArrayList<>();
    }

    /**
     *
     * @param steps Number of steps we perform after the warmup
     */
    public void run(int steps){
        warmup();
        for(int i = 0; i < steps; i++){
            int temp = step();
            streamArray.add(temp);
        }
    }

    /**
     * "Warp-up" before we start computing the stream cipher
     */
    private void warmup(){
        int warpUpRounds = 1152;
        for(int i = 0; i < warpUpRounds; i++){
            step();
        }
    }

    /**
     * Main method that controls when we should do the different computations
     *
     * @return The bit that will be added to the stream
     */
    private int step(){

        //First we find what bit that comes out of each of the LFSR
        int end93 = Lfsr93.endBit();
        int end84 = Lfsr84.endBit();
        int end111 = Lfsr111.endBit();

        //Then we can use the end bits to compute the start bit that will be pushed into the LFSR
        Lfsr93.startBit(end111);
        Lfsr84.startBit(end93);
        Lfsr111.startBit(end84);

        //Here we move every bit one position to the right
        Lfsr93.step();
        Lfsr84.step();
        Lfsr111.step();

        //Then we XOR the 3 bits together to get the stream bit
        int firstXor = Operations.bitXOR(end93, end84);

        return Operations.bitXOR(firstXor, end111);
    }

    /**
     * @return The stream cipher in String format
     */
    public String getStream(){
        return streamArray.toString();
    }

    /**
     * For the LFSR of 93 bits we add the IV to the first 80 bits
     *
     * @return List of a LFSR of 93 bits
     */
    public int[] lfsr93Maker(int[] IV) {
        int[] result = new int[93];
        for(int i = 0; i < 93; i++){
            if(i < IV.length) result[i] = IV[i];
        }
        return result;
    }

    /**
     * For the LFSR of 84 bits we load the first 80 bit with the key
     *
     * @return List of a LFSR of 84 bits
     */
    public int[] lfsr84Maker(int[] key){
        int[] result = new int[84];
        for(int i = 0; i < 84; i++){
            if(i < key.length) {
                result[i] = key[i];
            }
        }
        return result;
    }

    /**
     *
     *
     * @return List of a LFSR of 111 bits
     */
    public int[] lfsr111Maker(){
        int[] result = new int[111];
        for(int i = result.length -1; i >= 108; i--){
            result[i] = 1;
        }
        return result;
    }

}
