package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length>0)
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            FileWriter fileWriter = new FileWriter(args[1]);

            Pattern pattern = Pattern.compile("[\\d]+");


            while (bufferedReader.ready())
            {

                String line = bufferedReader.readLine();

                Character replace = (char) 65279;

                line = line.replaceAll(replace.toString(),"");

                String[] tmp = line.split("[\\s]+");

                for (String s:tmp)
                {
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find())
                    {
                        fileWriter.write(s);
                        fileWriter.write(" ");
                    }
                }
            }

            bufferedReader.close();

            fileWriter.close();

        }
    }
}
