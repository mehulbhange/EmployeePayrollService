package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class IOFileAPITest {
    private static String FILE_PATH = "E:\\BridgeLabz Fellowship\\IntelliJ\\EmployeePayroll\\src";
    private static String PERFORM_FILE_IO = "TestIOBasicOperations";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        // check if file exists
        Path homePath = Paths.get(FILE_PATH);
        Assertions.assertTrue(Files.exists(homePath));


        // Delete file and check file not exist
        Path performOperationsPath = Paths.get(FILE_PATH+"/"+PERFORM_FILE_IO);
        if (Files.exists(performOperationsPath))  {
            FileUtils.deleteFiles(performOperationsPath.toFile());
        }
        Assertions.assertTrue(Files.notExists(performOperationsPath));


        // Create directory
        Files.createDirectory(performOperationsPath);
        Assertions.assertTrue(Files.exists(performOperationsPath));


        // Create file
        IntStream.range(1,10).forEach(i->{
            Path testFile = Paths.get(performOperationsPath+"/test"+i);
            Assertions.assertTrue(Files.notExists(testFile));
            try{
                Files.createFile(testFile);
            }catch(IOException e){}
            Assertions.assertTrue(Files.exists(testFile));
        });

        // List Files, Directories as well as Files with extension
        Files.list(performOperationsPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(performOperationsPath).forEach(System.out::println);
        Files.newDirectoryStream(performOperationsPath, path -> path.toFile().isFile() &&
        path.toString().startsWith("test")).forEach(System.out::println);

    }

}
