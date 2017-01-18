package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream outputStream;
    public AdapterFileOutputStream(FileOutputStream outputStream) throws FileNotFoundException
    {

        this.outputStream = outputStream;
    }



    @Override
    public void close() throws IOException
    {
        this.outputStream.close();
    }

    @Override
    public void flush() throws IOException
    {
        this.outputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        this.outputStream.write(s.getBytes());
    }
}

