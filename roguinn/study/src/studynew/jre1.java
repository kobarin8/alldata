package studynew;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class jre1 {
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        String yourName = line;
        
        System.out.println("Hello, " + yourName);
        
    }
}