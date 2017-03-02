/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Xavier
 */
public abstract class HealthPointDateTime {
    
    public static String getdatetime()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0);
        String time = cal.getTime().toString();
        //Formatting
        SimpleDateFormat formatting = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String formatted = formatting.format(cal.getTime());   
        
        return formatted;
    }
    
    public static String ConvertJSDateTime(String JSDate) throws Exception
    {
        //Formatting
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy");
        Date data = sdf.parse(JSDate);
        SimpleDateFormat formatting = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String formatted = formatting.format(data);   
        
        return formatted;
        
    }    
}
