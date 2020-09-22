package com.company;

import java.util.Scanner;

public class Bot {

    public String upMsg() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void sendMsg(String msg) {
        System.out.println("" + msg);
    }

}
