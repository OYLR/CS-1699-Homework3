import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount{
	public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
		File file;
		InputStream is = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        Writer out;
        HashMap<String,Integer> wordMap = new HashMap<>();
        for(int i=0; i < args.length; i++){
        	file = new File(args[i]);
			is = new FileInputStream(file);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            String line = null;
           	while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(" ");
                for (String token : tokens){
  					if(wordMap.containsKey(token)){
                    	Integer value = wordMap.get(token);
                    	wordMap.put(token, value+1);
                	}else{
                    	wordMap.put(token, 1);
               		}
                }
			}
			bufferedReader.close();
        }
        file = new File("result_normal.txt");
        out = new FileWriter(file);
        Set<Map.Entry<String,Integer>> entrySet =  wordMap.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            out.write(entry.getKey() + ":" + entry.getValue() + "\n");
        }
        out.close();
        long endTime = System.currentTimeMillis();
        System.out.println("The execution time: " + (endTime - startTime) + "ms");
	}
}