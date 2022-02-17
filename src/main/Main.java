package main;

import core.Operations;
import core.Trivium;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Trivium myTriv = new Trivium();

        myTriv.run(40);
        String myStream = myTriv.getStream();
        System.out.println(myStream);

    }

}
