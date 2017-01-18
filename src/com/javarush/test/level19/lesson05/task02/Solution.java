package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1="";
        try
        {
            file1 = reader.readLine();
        }
        catch (IOException e) {} finally
        {
            try {reader.close();}catch (IOException e)
            {

            }
        }

        BufferedReader fis = null;
        try
        {
            fis = new BufferedReader(new FileReader(file1));
            int counter = 0;

            while (fis.ready()) {
                String [] tmp = fis.readLine().split("[/,;:.!?(){}\\s\\d]+");
                for (String s:tmp
                     )
                {
                    if (s.equals("world"))
                    {
                        counter++;
                    }

                }

            }

            System.out.println(counter);
        } catch (IOException e){}finally
        {
            try
            {
                if (fis!=null)
                {
                    fis.close();
                }
            }
            catch (IOException e){}
        }

    }
}
//d:\\1.txt