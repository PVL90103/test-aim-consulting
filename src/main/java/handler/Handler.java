package handler;

import executor.Executor;
import reader.CSVReader;
import reader.Reader;
import struct.Struct;
import writer.CSVWriter;
import writer.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static parser.CSVParser.getDistinctFileStructure;

public class Handler {
    /**
     * This method handling the files
     * @param filesForReading
     */
    public static void startHandling(List<String> filesForReading) {
        //Create synchronized list
        List<Struct> fileStructure = Collections.synchronizedList(new ArrayList<>());

        //Create list of threads
        List<Thread> threads = new ArrayList<>();

        if (!filesForReading.isEmpty()) {
            for(String item : filesForReading) {

                //Create csv reader for file
                Reader csvReader = new CSVReader(item);

                //Create and start thread executor
                Executor executor = new Executor(csvReader, fileStructure);
                Thread thread = new Thread(executor);
                thread.start();

                threads.add(thread);
            }

            //Waiting for thread finish
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //Create csv writer and give it unique elements from all files
            Writer csvWriter = new CSVWriter(getDistinctFileStructure(fileStructure));
            csvWriter.write();

            System.out.println("The results have been written at the directory: src/main/resources/output");
        }
    }
}
