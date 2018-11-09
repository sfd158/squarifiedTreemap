package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class countProjectTotLine 
{
	public static void read(String path)
	{
		totcnt = 0;
		count(path);
		System.out.println("Total lines count:" + totcnt);
	}
	
	public static int totcnt = 0;
	public static void count(String path)
	{
		File file = new File(path);
        if (file.exists()) 
        {
            File[] files = file.listFiles();
            if (null == files || files.length == 0)
            {
                return;
            } 
            else 
            {
                for (File file2 : files) 
                {
                    if (file2.isDirectory()) 
                    {
                        System.out.println(file2.getAbsolutePath());
                        count(file2.getAbsolutePath());
                    }
                    else 
                    {
                    	int cnt = 0;
                        try 
                        {
							BufferedReader read = new BufferedReader(new FileReader(file2));
							while(read.readLine()!=null)
							{
								cnt++;
							}
						} 
                        catch (IOException e)
                        {
							
						}
                        System.out.println(file2.getAbsolutePath() + " lines:" + cnt);
                        totcnt += cnt;
                    }
                }
            }
        }
	}
}
