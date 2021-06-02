import java.util.*;
import java.io.*;
class Train
{
    public static void main(String [] args)
    {
        String beforeHyderabadTrainA[]={"CHN","SLM","KRN","BLR"};//taking an array of stations for TrainA before Hyderabad
        String beforeHyderabadTrainB []={"TVC","SRR","MAQ","MAO","PNE"};//taking an array of stations for TrainA before Hyderabad
        ArrayList <String> afterHyderabadStationsDescending =new ArrayList<String>(Arrays.asList("GHY","NJP","PTA","NDL","AGA","BPL","ITJ","NGP"));
        //taking an arraylist of stations based on their distance from hyderabad in descending order
        String filepath="input.txt";
        Scanner sc=new Scanner(System.in);
        try{
            sc=new Scanner(new File(filepath));}
        catch(Exception e)
        {

        }
        ArrayList<String>TrainA=new ArrayList<String>();
        ArrayList<String>TrainB=new ArrayList<String>();
        ArrayList<String>ActiveSet=TrainA;
        String input="";
        while(sc.hasNext())
        {   
            input=sc.next();
            if(input.equals("TRAIN_A"))
            {
               
                continue;
            }
            else if(input.equals("TRAIN_B"))
            {   
                ActiveSet=TrainB;
             
                continue;
            }
          
            else
            {
                ActiveSet.add(input);
              
            }
           
        }
        
        System.out.print("ARRIVAL TRAIN_A ");
        for(String s:beforeHyderabadTrainA)
        {
            TrainA.removeAll(Collections.singleton(s));//removing stations before hyderabad from trainA
            
        }
        for(String s:TrainA)
        {
            System.out.print(s+" ");//Displaying trainA on arrival at hyderabad
        }
        System.out.println();
        System.out.print("ARRIVAL TRAIN_B ");
        for(String s:beforeHyderabadTrainB)
        {
                TrainB.removeAll(Collections.singleton(s));//removing stations before hyderabad from trainB
        }
        for(String s:TrainB)
        {
            System.out.print(s+" ");//Displaying train B on arrival at hyderabad
        }
        //Arranging train AB in descending order of distances 
        ArrayList<String>TrainAB=new ArrayList<>();
        TrainAB.add("ENGINE");
        TrainAB.add("ENGINE");
        for(String s:afterHyderabadStationsDescending)
        {
                if((TrainA.contains(s)||(TrainB.contains(s))))
                {
                    int occurences=Collections.frequency(TrainA,s)+Collections.frequency(TrainB,s);
                    for(int i=0;i<occurences;i++)
                    {
                        TrainAB.add(s);
                    }
                    
                }
        }
        //printing train on departure from hyderabad
        System.out.print("\nDEPARTURE TRAIN_AB ");
        for(String s:TrainAB)
        {
            System.out.print(s+" ");
        }

    }
   

}