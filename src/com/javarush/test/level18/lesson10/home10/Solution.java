package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final ArrayList<String> fileNameList = new ArrayList<>();
        String s;
        try
        {
            while (!(s = reader.readLine()).equals("end"))
            {
                fileNameList.add(s);
            }
            reader.close();
        }

        catch (IOException e)
        {
            System.out.println("Error while closing the reader");
        }

        String outputFile = fileNameList.get(0).substring(0,fileNameList.get(0).lastIndexOf("."));
        //System.out.println(outputFile);

        final Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");

        Collections.sort(fileNameList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2)
            {
                int i1=0;
                int i2=0;
                Matcher matcher1=pat.matcher(o1.substring(o1.lastIndexOf(".")));
                while (matcher1.find()) {
                    i1 = Integer.parseInt(matcher1.group());
                }

                Matcher matcher2=pat.matcher(o2.substring(o2.lastIndexOf(".")));
                while (matcher2.find()) {
                    i2 = Integer.parseInt(matcher2.group());
                }
                if (i1>i2){
                    return 1;}
                else if (i1<i2)
                {
                    return -1;}
                else return 0;
            }

        });



        //System.out.println(fileNameList);

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile, true);





            for (String a : fileNameList)
            {
                FileInputStream inputStream = new FileInputStream(a);


                    byte[] buff = new byte[1024];
                    while (inputStream.available() > 0)
                    {
                        int i = inputStream.read(buff);
                        fileOutputStream.write(buff, 0, i);
                    }



                    inputStream.close();

            }

        fileOutputStream.close();


    }
}



//d:\\Lion.avi.part1