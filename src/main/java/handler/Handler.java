package handler;

import executor.Executor;
import reader.CSVReader;
import reader.Reader;
import struct.Struct;
import writer.CSVWriter;
import writer.Writer;

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


        if (!filesForReading.isEmpty()) {
            for(String item : filesForReading) {

                //Create csvreader fir file
                Reader csvReader = new CSVReader(item);

                //Create and start thread executor
                Executor executor = new Executor(csvReader, fileStructure);
                Thread thread = new Thread(executor);
                thread.start();

                //Waiting for thread finish
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Create csvwriter and give it unique elements from all files
            Writer csvWriter = new CSVWriter(getDistinctFileStructure(fileStructure));
            csvWriter.write();

            System.out.println("The results have been written at the directory: src/main/resources/output");
        }
    }
}
