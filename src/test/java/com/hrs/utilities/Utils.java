package com.hrs.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    protected Logger log = LogManager.getLogger(Utils.class);

    public String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void cleanFolder(String directory) {
        try{
            FileUtils.cleanDirectory(new File(directory));
        }catch (IOException ioException){
            log.warn("File "+directory+ " not deleted");
        }
    }
}
