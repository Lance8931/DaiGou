package com.ljh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

	public static void copyFile(File fromFile,File toFile) throws IOException{
        //如果目标文件不存在，则创建
        File parentFile = toFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        if(!toFile.exists()){
            toFile.createNewFile();
        }
        //复制文件
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        
        ins.close();
        out.close();
    }
}
