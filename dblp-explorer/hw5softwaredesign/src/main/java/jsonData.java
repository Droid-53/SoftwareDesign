// The specifications for this project ask for a .JSON file to be inputted, NOT A TEXT FILE
// If you try to read from a text file, it will not be able to run, as the formatting can vary.



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class jsonData {

    public static void main(String[] args) throws IOException {
        LinkedList<JSONObject> ll = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String keyword = null, filePath = null;
        System.out.println("Enter a Keyword");
        keyword = sc.nextLine();
        int n;

        filePath = checkFile(filePath, keyword);
        readLines(filePath, keyword, ll);
        printLinkedList(ll);
    }

    public static String checkFile(String s, String k){
        BufferedReader rd = null;
        System.out.println("Enter file name without extension. Only .json files are accepted");
        Scanner sc = new Scanner(System.in);
        String filePath = "src/main/java/";


        try {
            s = sc.nextLine() + ".json";
            filePath = filePath + s;
            rd = new BufferedReader(new FileReader(filePath));
            System.out.println("File Exists. Finding your keywords now!");
        }
        catch(IOException ex) {
            System.err.println("Please make sure you are inputtting a .JSON file!");
        }

        return filePath;
    }

    public static void readLines(String s, String keyword, LinkedList<JSONObject> ll){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(s));
            String line = br.readLine();
            int counter = 0;
            while(line != null){
                if(line.contains(keyword)){
                    line.toLowerCase();
                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(line);
                    ll.add(obj);
                }
                counter++;
                //System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Wrong Input");
        } catch (ParseException e) {
            System.out.println("Could Not Parse");
        }
    }

    public static void printLinkedList(LinkedList<JSONObject> ll){
        for(int i = 0; i < ll.size(); i++){
            System.out.println("The Article is called: " + ll.get(i).get("title").toString());
            System.out.println("The Article references: " + ll.get(i).get("references").toString());
        }
    }

}
