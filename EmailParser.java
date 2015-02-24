
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;



public class EmailParser {
	
	static String[][] subjectNamePairs = new String[100000][2];

	static String[][] conversationList = new String[100000][2];
	
	public static String[][] GetSubjectNamePairs(File filename) {
		
		try{
        	
            Scanner inputStream = new Scanner(filename);
            
            int i = 0;
            
            while(inputStream.hasNext()){
            	
            	String data = inputStream.nextLine();
            	
            	String[] s = data.split(",\",,,\",");
            	
            	if(s.length < 1) {
            		continue;
            	}
            	
            	while(s.length < 2) {
            		data = data + inputStream.nextLine();
            		s = data.split(",\",,,\",");
            	}
            	
            	subjectNamePairs[i][0] = s[0];
            	subjectNamePairs[i][1] = s[1];
            	
//            	System.out.println(s[0]+ "             " + s[1]);
//            	System.out.println();
            	
            	i++;
            }

            inputStream.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
		
        System.out.println("********************Subject Name Pairs Generated************************");
		return subjectNamePairs;
	}// GetSubjectNamePairs()
	
	public static String[][] GetConversationList() {
		
		int i = 0;
		
		
		while(subjectNamePairs[i][0] != null) {
			ArrayList<String> associatedNames = new ArrayList<String>();
			String subjectPattern = subjectNamePairs[i][0];
			String subjectPatternFinal = "";
			for (int character = 0; character < subjectPattern.length(); character++){
			    char c = subjectPattern.charAt(character);        
			    if (c == '?' || c == '(' || c == ')' || c == '*' || c == '[' || c ==']') {
			    	break;
			    }
			    subjectPatternFinal += c;
			}
			Pattern p = Pattern.compile(".*"+subjectPatternFinal+".*");
			
			associatedNames.add(subjectNamePairs[i][1]);
			
			for(int j = 0; j < 100000; j++) {
				if(subjectNamePairs[j][0] == null) {
					break;
				}
				
				Matcher m = p.matcher(subjectNamePairs[j][0]);
				
				if(m.matches()) {
					if(Collections.binarySearch(associatedNames, subjectNamePairs[j][1]) < 0) {
						associatedNames.add(subjectNamePairs[j][1]);
						Collections.sort(associatedNames);
					}
				}
			}
			
			int counter = 0;
			
			for(int k = 0 ; k < associatedNames.size(); k ++){
				  for(int l = k+1 ; l < associatedNames.size(); l ++){
				    System.out.println(subjectPattern + "     *AN.GETK: " + associatedNames.get(k) + "," + "*AN.GETL: " + associatedNames.get(l)); 
					  System.out.println(counter);
					  counter++;
				  }
			}
			
			
			i++;
		}
		
		return conversationList;
	}
	
	public static void main(String[] args) {
		        
        File file = new File("testgodfile.csv");

        subjectNamePairs = GetSubjectNamePairs(file);
        
        conversationList = GetConversationList();
	}

}
