package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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
//

            List list=new ArrayList(map.entrySet());

            Collections.sort(list,new Comparator(){
                public int compare(Object obj1, Object obj2){
                    return Double.compare((double)(((Map.Entry)(obj1)).getValue()),((double)(((Map.Entry)(obj2)).getValue())));
                }
            });


            for (int i=list.size()-1; i >= 0;i--)
            {
                Map.Entry entry = (Map.Entry) list.get(i);
                Map.Entry entry1 = (Map.Entry) list.get(list.size()-1);
                if (i == list.size() - 1)
                {
                    System.out.println(entry1.getKey());

                } else if (Double.compare((double)entry.getValue(),(double)entry1.getValue())==0)
                {

                    System.out.println(entry.getKey());
                }

            }

            fis.close();
        }
    }
}
