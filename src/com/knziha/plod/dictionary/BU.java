package com.knziha.plod.dictionary;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.zip.Adler32;
import java.util.zip.InflaterOutputStream;


/**
 * @author KnIfER
 * @date 2018/05/31
 */
public class  BU{//byteUtils

	public static int calcChecksum(byte[] bytes) {
        Adler32 a32 = new Adler32();
        a32.update(bytes);
        int sum = (int) a32.getValue();
        return sum;
    }
	public static int calcChecksum(byte[] bytes,int off,int len) {
        Adler32 a32 = new Adler32();
        a32.update(bytes,off,len);
        int sum = (int) a32.getValue();
        return sum;
    }
    //解压等utils
    public static byte[] zlib_decompress(byte[] encdata,int offset,int ln) {
	    try {
			    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
			    InflaterOutputStream inf = new InflaterOutputStream(out); 
			    inf.write(encdata,offset, ln); 
			    inf.close(); 
			    return out.toByteArray(); 
		    } catch (Exception ex) {
		    	ex.printStackTrace(); 
		    	return "ERR".getBytes(); 
		    }
    }
	
	
	
}
	


