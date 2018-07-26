package Credentials;
import tests.AppiumTests;

import java.io.*;

public class CmdLine {
    public static void main(String[] args) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
//                "cmd.exe", "/c", "appium --address localhost --port 4723 --session-override");
//        "cmd.exe", "/c", "adb kill-server");
//        "cmd.exe", "/c", "adb start-server");
        "cmd.exe", "/c", "adb devices");


        builder.redirectErrorStream(true);
        Process p = builder.start();
//        p.waitFor();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }

}