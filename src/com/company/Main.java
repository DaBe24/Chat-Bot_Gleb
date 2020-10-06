package com.company;

public class Main
{
    public static void main(String[] args) {
        Bot gleb = new Bot();
        gleb.sendMessage("I am Gleb. What is your name? " +
                "\n(Write your name to start work)");
        String name = "user";
        while (true){
            String text = gleb.readMessage();
            if (Bot.Status.isEmpty() || Bot.Status.get(name).equals("start2")) {
                Bot.Status.put(text, "start2");
                name = text;
            }
            String result = gleb.reply(text, name);
            gleb.sendMessage(result);
            if (Bot.Status.isEmpty())
                return;
        }
    }
}

/*
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
*/


