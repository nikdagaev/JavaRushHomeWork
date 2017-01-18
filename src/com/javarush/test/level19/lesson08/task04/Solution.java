package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream oldStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream newStream = new PrintStream(byteArrayOutputStream);

        System.setOut(newStream);

        testString.printSomething();

        String s = byteArrayOutputStream.toString();

        String[]arr = s.split("[=\\s]");

        System.setOut(oldStream);

        if (arr[1].equals("+"))
        {

            int resPlus = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
            System.out.printf("%d + %d = %d", Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), resPlus);
        }
        else if (arr[1].equals("-")){

            int resMinus = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
        System.out.printf("%d - %d = %d", Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), resMinus);
        }
                else if (arr[1].equals("*")){
                int resMultiple = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
                System.out.printf("%d * %d = %d",Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), resMultiple );


        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

