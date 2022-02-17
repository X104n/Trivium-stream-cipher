package main;

import core.Trivium;

public class Main {
    public static void main(String[] args) {
        Trivium myTriv = new Trivium();

        myTriv.run(20);
        String myStream = myTriv.getStream();
        System.out.println(myStream);
    }
}
