package com.alexserden;


import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < args.length; i++) {
            executor.submit(new MyRunnable(args[i]));

        }
    }


    static class MyRunnable implements Runnable {
        String fileName;
        File file;

        public MyRunnable(String fileName) {
            this.fileName = fileName;

        }


        @Override
        public void run() {
            file = new File(fileName);

            System.out.println(getFileExtension(file) + " " + file.length());


        }

        private static String getFileExtension(File file) {
            String fileName = file.getName();
            if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
                return fileName.substring(fileName.lastIndexOf(".") + 1);
            else return "файл не имеет расширения";
        }
    }
}
