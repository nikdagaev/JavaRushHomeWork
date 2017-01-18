package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();


        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);

       // FileOutputStream in2 = new FileOutputStream(file2);

        byte [] buff = new byte[in1.available()];
        while (in1.available()>0)
        {
            in1.read(buff);
        }
        FileOutputStream out = new FileOutputStream(file1);

        while (in2.available()>0)
        {
            out.write(in2.read());
        }

        for (int i = 0; i < buff.length;i++)
        {
            out.write(buff[i]);
        }


        in1.close();
        in2.close();

        out.close();
        reader.close();

    }
}
