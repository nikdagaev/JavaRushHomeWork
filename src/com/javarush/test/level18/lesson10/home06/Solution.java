package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;

import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception
    {
        if (args.length>0)
        {

            FileInputStream stream = new FileInputStream(args[0]);

            List<Integer> integerList = new ArrayList<>();

            while (stream.available()>0)
            {
                integerList.add(stream.read());
            }

            Collections.sort(integerList); //System.out.println(integerList);

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();


            for (int i = 0; i < integerList.size(); i++)
            {
                int a=(integerList.lastIndexOf(integerList.get(i))+1)-integerList.indexOf(integerList.get(i));
                treeMap.put(integerList.get(i),a);
               }





            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                int temp =  entry.getKey();
                System.out.println((char)temp + " " + entry.getValue());
            }
            stream.close();
            }



        }

    }

