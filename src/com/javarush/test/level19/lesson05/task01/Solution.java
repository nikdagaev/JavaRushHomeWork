package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1="";
        String file2="";
        try
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }
        catch (IOException e) {} finally
        {
            try {reader.close();}catch (IOException e)
            {

            }
        }

        FileInputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try
        {
            inputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            int count = 1;
            while (inputStream.available()>0)
            {
                int tmp = inputStream.read();
                if (count%2 == 0)
                {
                    fileOutputStream.write(tmp);
                }
                count++;
            }
        }
        catch (Exception e){}
        finally
        {
            try
            {
                if (inputStream!=null){inputStream.close();}
            }
            catch (Exception e){}
            try
            {
                if (fileOutputStream!=null){fileOutputStream.close();}
            }
            catch (Exception e){}
        }
    }
}
//d:\\1.txt
//d:\\2.txt