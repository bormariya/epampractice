package javase05.t01;

import javase04.t03.MyFileReader;
import javase04.t03.MyFileWriter;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilesProcessing {
    @Getter
    private Map<Integer, File> files;
    private Integer numerator;

    private FilesProcessing(){
        files = new LinkedHashMap<>();
    }

    public static FilesProcessing create(){
        return new FilesProcessing();
    }

    public String getContent(Integer numberOfList){
        return this.getContent(files.get(numberOfList).getPath());
    }

    public String getContent(String path) {
        numerator = 0;
        File currentFile = new File(path);
        String result = "";
        if(currentFile.isFile()){
            String type = currentFile.getName().substring(
                    currentFile.getName().lastIndexOf("."), currentFile.getName().length());
            if(type.equals(".txt")){
                try {
                    MyFileReader reader = MyFileReader.create(path);
                    result = "File is \"" + currentFile.getName() + "\": \n" + reader.getContent();
                    reader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("There is no file \"" + path + "\"");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Can not read a line in the file \"" + path + "\"");
                    e.printStackTrace();
                }

            }
        }
        else
            if(currentFile.listFiles() != null){
                files.clear();
                StringBuilder builder = new StringBuilder();
                builder.append("Directory is \"")
                        .append(currentFile.getName().equals("") ? currentFile : currentFile.getName())
                        .append("\": \n");
                //noinspection ConstantConditions
                for(File file : currentFile.listFiles()) {
                    files.put(++numerator, file);
                    builder.append(numerator).append(") ")
                            .append(files.get(numerator).getName()).append(";\n");
                }
                result = builder.toString();
            }

        return result;
    }

    public void writeData(String filePath, String data, boolean clearOldData){
        try {
            MyFileWriter writer = MyFileWriter.create(filePath);
            if(clearOldData)
                writer.writeNewData(data);
            else
                writer.writeData(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Can not write data to the file \"" + filePath + "\"");
            e.printStackTrace();
        }
    }

    public boolean deleteFile(Integer numberOfFile){
        File file  = files.get(numberOfFile);
        return file.delete();
    }

    public Integer maxListValue() {
        return numerator;
    }
}
