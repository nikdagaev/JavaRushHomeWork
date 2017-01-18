package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        if (args.length>0)
        {
            BufferedReader fis = new BufferedReader(new FileReader(args[0]));

            Map<String,Double> map = new TreeMap<>();
            String line;
            while ((line = fis.readLine()) != null)
            {
                Character replace = (char) 65279;
                line = line.replaceAll(replace.toString(),"");
                String [] tmp = line.split("[\\s]+");

                if (map.containsKey(tmp[0]))
                {
                    double value = (map.get(tmp[0]));
                    value += Double.parseDouble(tmp[1]);
                    map.put(tmp[0], value);
                }
                else map.put(tmp[0], Double.parseDouble(tmp[1]));
            }
            for (Map.Entry entry: map.entrySet()
                 )
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


            fis.close();
        }
    }
}
