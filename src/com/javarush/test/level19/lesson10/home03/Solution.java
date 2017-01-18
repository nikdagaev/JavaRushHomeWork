package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
    if (args.length>0)
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String line;
        while ((line=reader.readLine())!=null)
        {
            Character replace = (char) 65279;
            line = line.replaceAll(replace.toString(),"");
            String[]tmp = line.split("[\\s]+");

            GregorianCalendar calendar = new GregorianCalendar(
                    Integer.parseInt(tmp[tmp.length - 1]), Integer.parseInt(tmp[tmp.length - 2]) - 1, Integer.parseInt(tmp[tmp.length - 3]));

            String name = "";
            for (int i = 0; i<tmp.length-3;i++ )
            {
                if (i==tmp.length-4) {name = name + tmp[i];}
                else name = name + tmp[i] + " ";
            }
            Person person = new Person(name, calendar.getTime());
            PEOPLE.add(person);
        }

        reader.close();



    }

    }

}
