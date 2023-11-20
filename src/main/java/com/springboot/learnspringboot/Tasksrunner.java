package com.springboot.learnspringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.newBufferedReader;
@RestController
public class Tasksrunner {

    public static Boolean check(String str) throws IOException , CustomException{
        Path path = Paths.get("src/main/resources/File.txt");
        BufferedReader reader= newBufferedReader(path);
        String line="";
        while((line =reader.readLine())!=null){
            if(line.contains(str)){
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/Task")
    public Object getValue() throws IOException, CustomException {
        String str = "aaaaaaaaaaaaaaa";
        Path path = Paths.get("src/main/resources/File.txt");
        int res = 0;
        if(str.length()>10){
            //return "length Exceeded";
            throw  new CustomException("length exceeded");

            //throw new CustomException("Length exceeded");resources
        }
        try {
            if (check(str)){
                throw  new CustomException("already exists");
                //System.out.println("already exists");
            }
            /*if(reader.readLine().contains(str)){
                System.out.println("string already existed");
            }*/
            else{
                char[] characters = str.toCharArray();
                //System.out.println(str);
                //ConcurrentMap<Character, LongAdder> occurences= new ConcurrentHashMap<>();
                for (char ch : characters) {

                    res += (int) ch;
                }
                if(!Files.exists(path)){
                    Files.createFile(path);
                }
                //System.out.println(res);
                //HashMap<String,Integer> lst = new HashMap<String,Integer>();
                //lst.put(str,res);
                //Files.write(str,lst.put(str,res));
                try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                    writer.write(str + "," + res+";");
                    writer.newLine();
                    return res;
                }
            }
        }
        /*catch (IOException ex){
            ex.printStackTrace();

        }*/ catch (CustomException e) {
            return e;
            //throw new RuntimeException(e);
        }



    }
    static class  CustomException extends Exception{
        //private  String mes;
        public CustomException(String message){
            super(message);
            //this.mes=message;

        }

//        @Override
//        public String toString() {
//            return mes;
//        }
    }

}