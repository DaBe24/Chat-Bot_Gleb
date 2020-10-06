package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Bot {

    public static HashMap<String, String> Status = new HashMap<>();

    public String readMessage() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void sendMessage(String text) {
        System.out.println(text);
    }

    public String reply(String text, String name) {
        if ("wait".equals(Status.get(name))) {
            Status.put(name, text);
        }
        switch (Status.get(name)) {
            case "/help" -> {
                Status.put(name, "wait");
                return DoHelp();
            }
            case "start2" -> {
                sendMessage(text);
                Status.put(text, "wait");
                return "Nice to meet you, " + text + "!" +
                        "\nType '/help' to see my commands.";
            }
            case "/reset" -> {
                Status.put(name, "start2");
                return DoReset();
            }
            case "/play" -> {
                Status.put(name, "wait");
                return DoPlay();
            }
            case "/dead" -> {
                Status.put(name, "wait");
                return DoDead(name);
            }
            default -> {
                Status.put(name, "wait");
                return "I don't understand!";
            }
        }
    }

    private static String DoReset() {
        return "What is your new name?";
    }

    private static String DoDead(String name) {
        Status.clear();
        return name + ", goodbye. Gleb is out!";
    }

    private static String DoPlay() {
        return "null";
    }

    private static String DoHelp() {
        return "Oh hello there! I am Gleb, your text-chat bot." +
                "\nMy command list is:" +
                "\n/help - command list;" +
                "\n/dead - end current session;" +
                "\n/play - doesn't work" +
                "\n/reset - rename";
    }
}