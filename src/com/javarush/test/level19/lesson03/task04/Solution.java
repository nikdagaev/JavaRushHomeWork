package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;

import java.util.Calendar;
import java.util.Date;

import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
       private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {

              String[] arr = scanner.nextLine().split(" ");


            Calendar birthDate = new GregorianCalendar(Integer.parseInt(arr[5]), Integer.parseInt(arr[4])-1, Integer.parseInt(arr[3]));
            return new Person(arr[1],arr[2],arr[0], birthDate.getTime());
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
