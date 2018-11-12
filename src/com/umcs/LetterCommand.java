package com.umcs;

import java.io.FileWriter;
import java.io.IOException;

public class LetterCommand implements Command {

    private int hour;
    private int minute;
    private String path;


    public LetterCommand(int hour, int minute, String path) {
        this.hour = hour;
        this.minute = minute;
        this.path = path;
    }

    @Override
    public void wykonaj(int hour, int minute) {
        if (this.hour == hour && this.minute == minute) {
            try {
                System.out.println("<LetterCommand>");
                FileWriter zapis = new FileWriter(path, true);
                zapis.write("savetofile" + '\n');
                zapis.close();
            } catch (IOException e) {
                System.out.println("IOException " + e.getMessage());
            }
        }

    }
}
