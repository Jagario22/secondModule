package com.nix.module.fileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CustomFileWriter implements FileWriter {
    private String text;
    private File file;

    public CustomFileWriter(String text, String path) {
        this.text = text;
        file = new File(path);
    }

    public CustomFileWriter() {
    }

    @Override
    public void writeIntoFile() {

        try (PrintStream out = new PrintStream(new FileOutputStream(file.getPath()))) {
            String[] str = text.split(" ");
            for (String val : str)
                out.println(val);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
