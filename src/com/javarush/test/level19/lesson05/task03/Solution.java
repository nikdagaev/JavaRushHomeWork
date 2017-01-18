package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;



public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


         String   file1 = reader.readLine();
          String  file2 = reader.readLine();
       reader.close();



           BufferedReader fis = new BufferedReader(new FileReader(file1));
           FileWriter fileWriter = new FileWriter(file2);




            String line;
            while ((line = fis.readLine()) != null)
            {
                String w = line.replace((char) 65279, ' ');
                String [] tmp = w.split(" ");

                for (String s : tmp)
                {

                    if (s.matches("[\\d]+"))
                    {
                        fileWriter.write(s);
                        fileWriter.write(" ");
                    }



                }

            }

        fis.close();
            fileWriter.close();
    }
}
//d:\\1.txt
//d:\\2.txt