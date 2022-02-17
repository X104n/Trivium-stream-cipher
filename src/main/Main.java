package main;

import core.Trivium;

public class Main {
    public static void main(String[] args) {
        testData();

        mandatoryStreamCipher();
    }

    private static void testData(){
        Trivium testTrivium = new Trivium(Generator.testIVMaker(), Generator.testKeyMaker());
        testTrivium.run(40);
        System.out.println("\nThe test data trivium result (first 40 bits): ");
        System.out.println(testTrivium.getStream());
    }

    private static void mandatoryStreamCipher(){
        Trivium mandatoryTrivium = new Trivium(Generator.mandatoryIVMaker(), Generator.mandatoryKeyMaker());
        mandatoryTrivium.run(1000);
        System.out.println("\nThis should be the 1000 bit stream cipher using the key and IV provided in the mandatory note: ");
        System.out.println(mandatoryTrivium.getStream());
    }

}
