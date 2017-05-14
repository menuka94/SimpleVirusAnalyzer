package simpleantivirus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author menuka
 */
public class HashAnalyzer {
    private static File file = new File("./md5Hashes.txt");
    
    /**
     * 
     * @param input
     * @return true if input is present in the list of known hashes of malicious files,
     * return false otherwise
     */
    public static boolean checkMd5(String input){
        System.out.println("file.canRead(): "+file.canRead());
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                if(input.equals(line)){
                    br.close();
                    return true;
                }
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }finally{
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HashAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public static void setFile(File file){
        HashAnalyzer.file = file;
    }
}
