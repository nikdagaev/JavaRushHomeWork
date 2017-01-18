package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        try
        {
            while (!(s=reader.readLine()).equals("exit"))
            {

                new ReadThread(s).start();



            }
            reader.close();
        }catch (Exception e){}


        //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {

        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run()
        {

            FileInputStream in;
             try
             {
                 in = new FileInputStream(this.fileName);

                 Map <Integer, Integer> map = new HashMap<>();
                 while (in.available() > 0)
                 {
                     Integer tmp = in.read();
                     if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
                     else map.put(tmp, 1);
                 }
                 Integer maxValueInMap = Collections.max(map.values());
                 for (Map.Entry<Integer, Integer> pair : map.entrySet())
                 {
                     if (pair.getValue() == maxValueInMap)
                         resultMap.put(fileName, pair.getKey());
                 }

                 in.close();
             }catch (Exception e){}


        }



        }



    }

