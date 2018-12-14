package com.lxy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        File file = new File("sss");
        try {
            BufferedInputStream s = new BufferedInputStream(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
