package com.umcs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Command> commands = new ArrayList<>();
        commands.add(new NumberCommand(10, 10, "plik.txt"));
        commands.add(new NumberCommand(10, 11, "plik.txt"));
        commands.add(new LetterCommand(10, 12, "plik.txt"));
        commands.add(new LetterCommand(10, 13, "plik.txt"));
        commands.add(new SummaryCommand(10, 14, "plik.txt"));
        commands.add(new SummaryCommand(10, 15, "plik.txt"));
        int hournow = 0;
        int minutenow = 0;
        while (hournow <= 11 && minutenow <= 60) {
            System.out.println("jest godzina " + hournow + ":" + minutenow);
            for (Command c : commands) {
                c.wykonaj(hournow, minutenow);
            }
            minutenow++;
            if (minutenow == 59) {
                minutenow = 0;
                hournow++;
            }


        }


    }
}
