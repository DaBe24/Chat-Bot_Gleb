package com.company;


public class Main
{

    public static void main(String[] args) {
        Bot gleb = new Bot();
        gleb.sendMsg("I am Gleb. Who are you?");
        String name = gleb.upMsg();
        gleb.sendMsg(".Hi, " + name + "!");
        while (true){
            String text = gleb.upMsg();
            switch (text){
                case "/help","/start":
                    gleb.sendMsg("I am not working!");
                    break;
                case "/dead":
                    gleb.sendMsg("I died");
                    return;
                default:
                    break;
            }
        }
    }
}

