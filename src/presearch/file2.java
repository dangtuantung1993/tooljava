/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;

/**
 *
 * @author TDG
 */
public class file2 {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
   File fileA = new File("a.txt");
   File fileB = new File("b.txt");
   File fileC = new File("c.txt");

// Ghi 2 dòng 'xin chào' và 'stackjava.com' ra file a.txt với encoding là UTF-8
FileUtils.writeStringToFile(fileA, "dangtuantung1993@gmail.com vannhuthe1;", "UTF-8",true);
FileUtils.writeStringToFile(fileA, "\nsonkute1993@gmail.com sonkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileA, "\nvuongkute1993@gmail.com vukute;", "UTF-8",true);
FileUtils.writeStringToFile(fileA, "\nvukute1993@gmail.com.com vuongkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileA, "\nhungkute1993@gmail.com hungkute;", "UTF-8",true);

// Đọc dữ liệu của file a.txt thành 1 string
String data = FileUtils.readFileToString(fileA, "UTF-8");
System.out.println(data);
// Đọc dữ liệu của file a.txt thành các dòng và lưu lại thành 1 List
List<String> lines = FileUtils.readLines(fileA, "UTF-8");
System.out.println(lines);
FileUtils.writeStringToFile(fileB, "dangtuantung1993@gmail.com vannhuthe1;", "UTF-8",true);
FileUtils.writeStringToFile(fileB, "\nhuongkute1993@gmail.com sonkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileB, "\nthuykute@gmail.com vukute;", "UTF-8",true);
FileUtils.writeStringToFile(fileB, "\nvukute1993@gmail.com.com vuongkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileB, "\nhungkute1993@gmail.com hungkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileB, "\ncuongkute@gmail.com hungkute;", "UTF-8",true);
FileUtils.writeStringToFile(fileB,"\nduongkute.com hungkute;", "UTF-8",true);
String data2 = FileUtils.readFileToString(fileB, "UTF-8");
System.out.println(data2);
List<String> lines2 = FileUtils.readLines(fileB, "UTF-8");
 
    for(int i=0;i<lines2.size();i++)
    {
           if(!lines.contains(lines2.get(i)))
           {
              FileUtils.write(fileC, lines2.get(i) +"\n", true);
           }
    }
String data3 = FileUtils.readFileToString(fileC, "UTF-8");
System.out.println(data3);

FileUtils.writeStringToFile(fileA, data3, true);
FileUtils.forceDelete(fileC);






    
    
   

// Copy dữ liệu file a.txt sang file b.txt
//FileUtils.copyFile(fileA, fileB);
// xóa file a.txt
//FileUtils.forceDelete(fileA);
    }

    private static CharSequence lines2(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
    
   
    
    
