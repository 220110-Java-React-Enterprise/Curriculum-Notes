import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FileLogger - Singleton used to log exceptions and other info to a file or maybe
 * another data source.
 * Interface includes: 2 methods to get the singleton, and 2 methods to input info to be logged
 */
public class FileLogger {
    //What do we need to set this up as a singleton?
    //private constructor
    //private static reference to singleton object
    //public getter that creates or returns our singleton
    private static FileLogger fileLogger;
    private static String filePath;
    private static boolean consoleOutput;
    private static int stackTraceSize;



    private FileLogger() {
        filePath = "logs/";
        consoleOutput = false;
        stackTraceSize = 10;
    }

    public static FileLogger getFileLogger() {
        if(fileLogger == null) {
            fileLogger = new FileLogger();
        }
        return fileLogger;
    }

    public static FileLogger getFileLogger(String path) {
        if(fileLogger == null) {
            fileLogger = new FileLogger();
        }
        filePath = path;
        return fileLogger;
    }


    public void log(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(fileLogger.getTimestamp())
                .append(" - ")
                .append(e.getMessage())
                .append("\n")
                .append(fileLogger.formatStackTrace(e))
                .append("\n");
        fileLogger.writeToLog(sb.toString());
    }

    public void log(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(fileLogger.getTimestamp())
                .append(" - ")
                .append(str)
                .append("\n");
        fileLogger.writeToLog(sb.toString());
    }

    private String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss]");
        return formatter.format(LocalDateTime.now());
    }

    private String getFileName() {
        return filePath + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".log";
    }

    private String formatStackTrace(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stackTraceSize; i++) {
            if(i >= stackTrace.length) {
                break;
            }
            sb.append("\t");
            sb.append(stackTrace[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void writeToLog(String text){
        String fileName = getFileName();
        try(Writer fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(text);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO - figure out what to do if the excepton lgger throws an exception
        }

    }

}
/*
Identify the problem:
We don't want to sysout to the console anymore. We won't always have access to the console output.
We need something better than giving debug/operation feedback to the developers via console. We want to log the
information somewhere less volatile AKA more permanent.

Where can we put our log messages?
In a file on the drive.
the database
We can consume some sort of file logging API - where we POST messages via HTTP request to a service

How will we do it?
We will start with flat file logger and if we get time, add in database logging

What do we send to the logger?
We can send over an Exception object, and this includes the stack trace and message
We can send just a plain string
some object reflection, we send along an object and reflect upon it to generate a log message
which contains relevant info about that object - perhaps we add this functionality as part of a
reflection review Friday


Design:
We have some info we want to store, maybe an exception or breadcrumb. Instead of printing stack trace
we could log that string.
We may want to set some sort of level or threshold for how much info we log.
We need a reference to our destination, either a File or Connection
Call/Invoke some method which starts the logging process.
We want to maybe add a timestamp
We want to format the info into a useful and readable string
Append the info to the end of the file, or insert into the table.


How should the flat file be formatted?
Input: Exception
    Start with timestamp
    exception message
    exception class
    some number of lines from the stack trace
        We don't need the top few lines. the stack trace will include the methods invoked to get
        to the file logger.
    Start with the first line of our message having the timestamp and some info, then we so the stack trace
    backwards from most to least recent, each line on its own line, tab-indented.
    How much stack trace do we want to keep? maybe 5-10 most recent frames,
    or maybe determine this based on logging level or threshold

Input: Message
    Start with timestamp
    message




 */