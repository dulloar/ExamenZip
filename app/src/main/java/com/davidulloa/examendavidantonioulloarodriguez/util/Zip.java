package com.davidulloa.examendavidantonioulloarodriguez.util;


import android.util.Log;

import com.davidulloa.examendavidantonioulloarodriguez.app.MyApp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.inject.Singleton;

import dagger.Module;
import okhttp3.ResponseBody;

/**
 * Clase para comprimir o descomprimir archivos zip.
 *
 * @author David Antonio Ulloa Rodriguez.
 *
 * @version 1.0
 * */


public class Zip {



    public void unZip(ResponseBody body){
        //File strdir = MyApp.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        //ile file = new File(Environment.getExternalStoragePublicDirectory((Environment.DIRECTORY_DOWNLOADS)),"employees_data.json.zip");
        File file = new File(MyApp.getContext().getExternalFilesDir(null) + File.separator +"employees_data.json.zip");
        /*if(!file.exists()){
            file.mkdir();
        }*/
        //File file = File.createTempFile("employees_data.json",".zip",strdir);



        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            byte[] fileReader = new byte[4096];
            long filesSize = body.contentLength();

            inputStream = new BufferedInputStream(body.byteStream(),4096);
            outputStream = new FileOutputStream(file);
            int rbuffer;
            long fileSizeDownloadedInByte = 0;
            int fileDownloadedInPercentage = 0;
            while(true){
                rbuffer = inputStream.read(fileReader);

                if(rbuffer == -1){
                    break;
                }
                fileSizeDownloadedInByte += rbuffer;

                outputStream.write(fileReader,0,rbuffer);

            }
            outputStream.flush();



        }catch (IOException e){
            Log.d("Error",e.getMessage());
        }finally {
            inputStream.close();
            outputStream.close();
        }

        unzipFile("employees_data.json.zip");
    }

    private void unzipFile(String s){
        InputStream inputStream;
        ZipInputStream zipInputStream;
        ZipEntry ze = null;
        try{
            String file;
            //inputStream = new FileInputStream(Environment.getExternalStoragePublicDirectory((Environment.DIRECTORY_DOWNLOADS))+s);
            inputStream = new FileInputStream(MyApp.getContext().getExternalFilesDir(null) + File.separator +s);
            zipInputStream = new ZipInputStream(inputStream);
            ze = zipInputStream.getNextEntry();

            byte[] buffer = new byte[4096];
            int count = 0;
            while (ze != null){
                file = ze.getName();
                if(ze.isDirectory()){
                    File fi = new File(MyApp.getContext().getExternalFilesDir(null) + File.separator +file);
                    fi.createNewFile();
                    continue;
                }

                FileOutputStream fout = new FileOutputStream(MyApp.getContext().getExternalFilesDir(null) + file);

                do{
                    fout.write(buffer, 0, count);
                }
                while ((count = zipInputStream.read(buffer)) != -1);


                fout.close();
                zipInputStream.closeEntry();
            }

            zipInputStream.close();

        }catch (IOException e){
            Log.d("Error",e.getMessage());
        }
    }

}
