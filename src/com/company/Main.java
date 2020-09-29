package com.company;

import java.util.HashMap;

public class Main
{
    public static HashMap <String, String>Status = new HashMap<>();

    public static void main(String[] args) {
        CreateBot();
        /*Bot gleb = new Bot();
        gleb.sendMsg("Write \"/start\" to start work");
        while (true){
            String text = gleb.upMsg();
            switch (text) {
                case "/help" -> gleb.sendMsg("Oh hello there! I am Gleb, your text-chat bot." +
                        "\nMy command list is:" +
                        "\n/help - command list;" +
                        "\n/dead - end current session;" +
                        "\n/play - doesn't work");
                case "/start" -> {
                    gleb.sendMsg("I am Gleb. What is your name?");
                    String name = gleb.upMsg();
                    Status = "Waite";
                    gleb.sendMsg("Nice to meet you, " + name + "!" +
                            "\nType '/help' to see my commands.");
                }
                case "/play" -> {
                    gleb.sendMsg("null");
                }
                case "/dead" -> {
                    gleb.sendMsg("I died!!!");
                    return;
                }
                default -> gleb.sendMsg("I don't understand!");
            }
        }*/
    }

    private static void CreateBot() {
        Bot gleb = new Bot();
        gleb.sendMsg("I am Gleb. What is your name?");
        String name = gleb.upMsg();
        Status.put(name, "/start");
        gleb.sendMsg("Nice to meet you, " + name + "!" +
                "\nType '/help' to see my commands.");
        UpMsg(gleb, name);
    }

    private static void CommandList(Bot gleb, String name){
        switch (Status.get(name)) {
            case "/help" -> DoHelp(gleb, name);
            case "/play" -> DoPlay(gleb, name);
            case "/reset" -> DoReset(gleb);
            case "/dead" -> DoDead(gleb, name);
            default -> {
                gleb.sendMsg("I don't understand!");
                UpMsg(gleb, name);
            }
        }
    }

    private static void UpMsg(Bot gleb, String name) {
        Status.put(name, gleb.upMsg());
        CommandList(gleb, name);
    }

    private static void DoReset(Bot gleb) {
        gleb.sendMsg("What is your new name?");
        String name = gleb.upMsg();
        gleb.sendMsg("Nice to meet you, " + name + "!");
        UpMsg(gleb, name);
    }

    private static void DoDead(Bot gleb, String name) {
        gleb.sendMsg(name + ", goodbye. Gleb is out!");
        Status.clear();
    }

    private static void DoPlay(Bot gleb, String name) {
        gleb.sendMsg("null");
        UpMsg(gleb, name);
    }

    private static void DoHelp(Bot gleb, String name) {
        gleb.sendMsg("Oh hello there! I am Gleb, your text-chat bot." +
                "\nMy command list is:" +
                "\n/help - command list;" +
                "\n/dead - end current session;" +
                "\n/play - doesn't work" +
                "\n/reset - rename");
        UpMsg(gleb, name);
    }
}

