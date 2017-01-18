package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream in = new FileInputStream(file2);
        FileInputStream in1 = new FileInputStream(file3);
        FileOutputStream out = new FileOutputStream(file1);

        while (in.available()>0)
        {
            out.write(in.read());
        }
        while (in1.available()>0)
        {
            out.write(in1.read());
        }

        in.close();
        in1.close();
        out.close();
reader.close();




    }
}
