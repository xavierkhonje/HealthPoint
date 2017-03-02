/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Xavier Khonje
 */
public abstract class upload {
    
    /*
    *This method is used to manage image uploads using byte streams
    */
    public static String uploadImage()
    { 
        return "Image Successfully Uploaded";
    }
    
    /*
    *This method is used to manage image uploads without streams
    *@Para Upload without using streams
    */    
    public static String uploadImage(String str)
    {
        
        return "";
    }

}
