package com.ivanov;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static String[] readerPatterns(String path) throws IOException {
        Scanner myReader = new Scanner(new File(path));
        ArrayList<String> temps = new ArrayList();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            temps.add(data);
        }
        myReader.close();

        String[] patternList = new String[temps.size()];
        for (int i = 0; i < patternList.length; i++) {
            patternList[i] = temps.get(i);
        }
        return patternList;
    }
}
