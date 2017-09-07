/*1. Напишите программу, которая считывает символы пока не встретится точка.
Также предусмотрите вывод количества пробелов.
Пояснение: создайте String words = "тут ваш текст. Ещё текст".
Ваша порграмма должна считать все символы пока не встретит в тексте строчку.
Считанные символы необходимо записать в файлик в файловую систему.
Так-же в этом файлике будут указано число встретившихся пробелов.*/

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Solution {

    private static int spacesCount = 0;

    public static void main(String[] args) throws IOException {
        String inpStr = getInputString();
        String outStr = StringRead(inpStr) + "\n Spaces: " + spacesCount;
        String path = getPath();
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(outStr);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static String getInputString() throws IOException {
        System.out.println("Enter your string:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static String getPath() throws IOException {
        System.out.println("Enter full path for saving:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static String StringRead(String str) {
        int pointIndex = str.length();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == '.')
                pointIndex = i;
            if (currChar == ' ')
                spacesCount++;
        }
        return str.substring(0, pointIndex);
    }
}