package com.company;


public class Main
{

    public static void main(String[] args) {
        Bot gleb = new Bot();
        gleb.sendMsg("I am Gleb. What is your name?");
        String name = gleb.upMsg();
        gleb.sendMsg("Nice to meet you, " + name + "!");
        gleb.sendMsg("Type '/help' to see my commands");
        while (true){
            String text = gleb.upMsg();
            switch (text){
                case "/help":
                    gleb.sendMsg("Oh hello there! I am Gleb, your text-chat bot.");
                    gleb.sendMsg("My command list is: " +
                            "/help - command list;" + " /dead - end current session; ");
                    break;
                case "/dead":
                    return;
                default:
                    break;
            }
        }
    }
}

