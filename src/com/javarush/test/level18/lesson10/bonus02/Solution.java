package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length>0)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            final Pattern patentForNum = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");


            if (args[0].equals("-c"))
            {
                BufferedReader fis = new BufferedReader(new FileReader(fileName));

                String s1=null;
                while (fis.ready())
                {
                    s1=fis.readLine();
                }

                Matcher matcher1 = patentForNum.matcher(s1.substring(0,8));
                int lastId = 0;
                while (matcher1.find()) {
                    lastId = Integer.parseInt(matcher1.group());
                }

                fis.close();

                ++lastId;

                String strToAppend = "";

                for (int i = 1; i<args.length-2;i++)
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

                String result = String.format("%n%-8d%-30.30s%-8.2f%-4d",lastId, strToAppend, Float.valueOf(args[args.length-2]), Integer.valueOf(args[args.length-1]));

                FileWriter writer = new FileWriter(fileName,true);

                writer.write(result);
                writer.write('\n');
                writer.close();
            }




        }
    }
}
//d:\\1.txt