package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;



public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader fis = new BufferedReader(new FileReader(args[0]));
        int counter = 0;
        try {
            while (fis.ready()) {
                Character ch = (char)fis.read();
                if (String.valueOf(ch).matches("[a-zA-Z]")){
                    counter++;
                }
            }
            fis.close();
        } catch (IOException e){}

        System.out.println(counter);

    }
}

