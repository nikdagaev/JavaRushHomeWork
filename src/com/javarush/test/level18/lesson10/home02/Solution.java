package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {

        BufferedReader fis = new BufferedReader(new FileReader(args[0]));
        int counterSpace = 0;
        double counterChar = 0.0;
        try {
            while (fis.ready()) {
                Character ch = (char)fis.read();
                if (String.valueOf(ch).equals(" ")){
                    counterSpace++;
                }
                counterChar++;
            }
            fis.close();
        } catch (IOException e){}


        double d = (counterSpace/counterChar)*100;
        System.out.println(String.format("%.2f", d));
    }
}
