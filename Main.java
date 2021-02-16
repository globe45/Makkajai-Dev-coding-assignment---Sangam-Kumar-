import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
//function used for isItemImported or not
   public static boolean isItemImport(String arr[]){
         for (String a : arr) 
          {
                 if (a.equals("imported"))   //Search for the given word
                 {
                //   System.out.println("yes");
                   return true;
                 }
                
          }
          
          return false;
       
   }
   
//function used for saletax are applied or not
   public static boolean saletax(String arr[]){
         for (String a : arr) 
          {
                 if (a.equals("book") || a.equals("chocolates") || a.equals("pill"))   //Search for the given word
                 {
                //   System.out.println("yes");
                   return false;
                 }
                
          }
          
          return true;
       
   }
   
   
   public static void main(String args[]) {
      System.out.println("Enter the required size of the array :: ");
      Scanner s = new Scanner(System.in);
      int size = s.nextInt();
      String myArray[] = new String [size];
      System.out.println("Enter the items one by one ");
     
      for(int i = 0; i<size; i++) {
         myArray[i] = s.nextLine();
      }
     
     float totalsaletax=0.0f;
     float totalval=0.0f;
     System.out.println("output");
     for(int j =0; j<myArray.length; j++){
       
        String arr[]=myArray[j].split(" ");
        
        
        try {
          
    //Actual business logic as per problem  
           float saletax=0.0f;
           int qnty=Integer.parseInt(arr[0]);
           float price=Float.parseFloat(arr[arr.length-1]);
        
        
           float pricewithtax = qnty*price;
           if(isItemImport(arr) && saletax(arr)){
               pricewithtax =qnty*(float)price*1.15f;
               saletax=(float)price*0.15f;
           }
           else{
           
               if(isItemImport(arr)){
                  pricewithtax =qnty*(float)price*1.05f; 
                  saletax=(float)price*0.05f;
               }
               
                if(saletax(arr)){
                  pricewithtax =qnty*(float)price*1.10f;
                  saletax=(float)price*0.10f;
               }
           }
           pricewithtax=Math.round(pricewithtax * 20.0f) / 20.0f;
           
           totalsaletax=totalsaletax+saletax;
           totalval=totalval+pricewithtax;
           
           String prevPrice=Float.toString(price);
           
           String currentPrice=Float.toString(pricewithtax);
           
           String Result=myArray[j].replaceAll(prevPrice,currentPrice);
           
           String FinalResult=Result.replaceAll(" at",":");
           
           System.out.println(FinalResult);
           
         
           
        
        
        
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            
        }
        
        
        
        
     }
     
     totalsaletax=Math.round(totalsaletax * 20.0f) / 20.0f;
     totalval=Math.round(totalval * 20.0f) / 20.0f;
     
    //  System.out.println(totalsaletax +" "+  totalval);
     
     System.out.println("Sales Taxes:"+totalsaletax);
     System.out.println("Total:"+totalval);
   }
}
