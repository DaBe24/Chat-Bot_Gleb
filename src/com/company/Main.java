package com.company;


public class Main
{

    public static void main(String[] args) {
        Bot gleb = new Bot();
        gleb.sendMsg("I am Gleb. Who are you?");
        String name = gleb.upMsg();
        gleb.sendMsg(name);
        while (true){
            String text = gleb.upMsg();
            switch (text){
                case "/help":
                    gleb.sendMsg("I am not working!");
                    break;
                case "/dead":
                    return;
                default:
                    break;
            }
        }
    }
}

