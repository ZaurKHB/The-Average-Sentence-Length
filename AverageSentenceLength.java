
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AverageSentenceLength {

	public static void main(String[] args) throws IOException {
		
		int setnce_num=0;
		int word_count = 0;
		int wlenglimt=4;												//default number limit for words
		String delimiter=".!?";											//default delimiters for separate sentences
		String path=args[0];											//taking file path from command prompt
		String context;
	    context = new String(Files.readAllBytes(Paths.get(path)));		//Storing text from file to String 
       
	   boolean inputD = true,inputL = true;							// booleans to determine -d and -l added or not

			
	   	//determine and if there is taking -d's value 
			for(int i=0;i<args.length;i++){		
				if( args[i].contains("-d") ){					
					delimiter=args[++i];
					inputD=false;
					break;
			}		 
		} 
			
		   	//determine and if there is taking -l's value 
			for(int i=0;i<args.length;i++){				
			 if( args[i].contains("-l") ){
			   wlenglimt=Integer.parseInt(args[++i]);
			   inputL=false;
			   break;
			}
		}
				
			//Notify user about inputs of program 
			if(inputL) 
				System.err.println("You Have not or incorrect set word number limit! Defaul it is 4");
				
			if(inputD)
				System.err.println("You Have not or incorrect set sentence enders! Defaul it is .!? ");				
		
			if( (inputD && inputL) ){
				System.err.println("The correct way: java appname -d delimiters  -l numberlimit ");
			System.err.println("Example: java appname -d .,?!  -l 4 "); }
			// End of Notification
        

       //Determination  number of sentence in context based on delimiters 
       for(int i = 0; i < context.length(); i++){
                
    	   char ch=context.charAt(i);
    	   
    	   String ender=String.valueOf(ch);
    	   	 	
    	   if(delimiter.contains(ender) )  
        
    	   setnce_num++ ;
        
        }
       // end of counting sentences
       
       
      
       // Separating words from context and  decide  is it word or not based on limit number 
       String [] words = context.split(" ");
         
          for(int i = 0; i < words.length; i++){
        	  	
        	  if( words[i].trim().length()>=wlenglimt) //use trim method to eliminate spaces
        		  word_count++;  
          }
          //end 
        
             //Prints all words block//
         // for (String word : words)
        //	  System.out.println(word);
        
          
          // Printing Results Block
		  		System.out.println("");
        System.out.println("Word number : "+word_count);
				System.out.println("");
        System.out.println("Sentence number: "+setnce_num);
				System.out.println("");
        System.out.println("Avarage Sentence Length: "+word_count/setnce_num);
				System.out.println("");
        System.out.println("Thanks for choosing us!!!");
        //end of program

      
		
	}

}
