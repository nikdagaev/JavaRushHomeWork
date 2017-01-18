package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws Exception {


        if (args.length>0)
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();


            if (args[0].equals("-u"))
            {
                BufferedReader fis = new BufferedReader(new FileReader(fileName));


                ArrayList<String> list = new ArrayList<>();

                while (fis.ready())
                {
                    list.add(fis.readLine());
                }

                fis.close();

                int id = 0;
                int pos = 0;
                for (int i=0;i<list.size();i++)
                {
                    String tmp = list.get(i).substring(0,8).trim();

                    if (tmp.equals(args[1]))
                    {

                        id=Integer.parseInt(tmp);
                        pos = i;

                    }
                }

                String strToAppend = "";

                for (int i = 2; i<args.length-2;i++)
                {


                    if (i!=args.length-3)
                    {
                        strToAppend+=(args[i]+" ");
                    }

                    else
                    {
                        strToAppend+=(args[i]);

                    }


                }

                String result = String.format("%-8d%-30.30s%-8.2f%-4d",id, strToAppend, Float.valueOf(args[args.length-2]), Integer.valueOf(args[args.length-1]));

                list.set(pos,result);

                FileWriter writer = new FileWriter(fileName);

                for (int i = 0; i<list.size();i++)
                {


                    if (i!=list.size()-1){
                        writer.write(list.get(i)+ '\n');}
                    else writer.write(list.get(i));


                }

                writer.close();



            }

            if (args[0].equals("-d"))
            {
                BufferedReader fis = new BufferedReader(new FileReader(fileName));


                ArrayList<String> list = new ArrayList<>();

                while (fis.ready())
                {
                    list.add(fis.readLine());
                }

                fis.close();

                int id = 0;
                int pos = 0;
                for (int i=0;i<list.size();i++)
                {
                    String tmp = list.get(i).substring(0,8).trim();

                    if (tmp.equals(args[1]))
                    {

                        pos = i;

                    }

                    if (id == Integer.parseInt(args[1]))
                    {

                        pos = i;

                    }
                }



                list.remove(pos);

                FileWriter writer = new FileWriter(fileName);

                for (int i = 0; i<list.size();i++)
                {

                    if (i!=list.size()-1){
                    writer.write(list.get(i)+ '\n');}
                    else writer.write(list.get(i));

                }

                writer.close();



            }

        }

    }
}
//d:\\1.txt