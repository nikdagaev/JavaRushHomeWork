package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name1 = reader.readLine();
        String name2 = reader.readLine();


        BufferedReader fis = new BufferedReader(new FileReader(name1));

        FileWriter writer = new FileWriter(name2);

        try {
            while (fis.ready()) {

                String s = fis.readLine();


                String[] test =  s.trim().split("\\s+");

                for (int i  =  0; i<test.length;i++)
                {

                    double d = Double.parseDouble(test[i]);
                    if (d>0)
                    {
                        String se = (new BigDecimal(d).setScale(0, RoundingMode.HALF_UP).intValue())+" ";
                        writer.write(se);
                    }
                    else
                    {
                        String se = (new BigDecimal(d).setScale(0, RoundingMode.HALF_DOWN).intValue())+" ";
                        writer.write(se);
                    }


                }


            }
            reader.close();
            fis.close();
            writer.close();
        } catch (IOException e){}

    }
}
