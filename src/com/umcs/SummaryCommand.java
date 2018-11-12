package com.umcs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SummaryCommand implements Command {
    private int hour;
    private int minute;
    private String path;


    public SummaryCommand(int hour, int minute, String path) {
        this.hour = hour;
        this.minute = minute;
        this.path = path;
    }

    @Override
    public void wykonaj(int hour, int minute) {
        if (this.hour == hour && this.minute == minute) {
            try {
                Scanner odczyt = new Scanner(new File(path));
                int sum = 0;
                while (odczyt.hasNextLine()) {
                    try {
                        sum += Integer.parseInt(odczyt.nextLine());
                    } catch (InputMismatchException|NumberFormatException ime) {
                        System.out.println("To niestety nie jest liczba :(");
                    }
                }
                System.out.println("<SummaryCommand>");
                FileWriter zapis = new FileWriter(path, true);
                zapis.write("sum:" + sum + '\n');
                zapis.close();
            } catch (IOException e) {
                System.out.println("IOException " + e.getMessage());
            }
        }

    }
}
