import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
class TameOfThrones
{
    public static void main(String args[])
    {
        ArrayList<String> Allies=new ArrayList<String>();
        Allies.add("SPACE");
        String filepath="input.txt";
        Scanner sc=new Scanner(System.in);
        try{
            sc=new Scanner(new File(filepath));
        }
        catch(Exception e)
        {}
        String LAND="",WATER="",AIR="",FIRE="",ICE="";
        Boolean flagland=true,flagair=true,flagwater=true,flagfire=true,flagice=true;
        while(sc.hasNext())
        {
            String input=sc.next();
            switch(input)
            {
                case "LAND":
                    LAND=sc.nextLine();
                    if(validCode(LAND,encrypt("PANDA",5)))
                    {   
                        if(flagland)
                        {
                            Allies.add("LAND");
                        }
                        flagland=false;
                        
                    }
                    break;
                case "WATER":
                    WATER=sc.nextLine();
                    if(validCode(WATER,encrypt("OCTOPUS",7)))
                    {   if(flagwater)
                        Allies.add("WATER");
                        flagwater=false;
                    }
                    break;
                case "AIR":
                    AIR=sc.next();
                    if(validCode(AIR,encrypt("OWL",3)))
                    {   if(flagair)
                        Allies.add("AIR");
                        flagair=false;
                    }
                    break;
                case "FIRE":
                    FIRE=sc.nextLine();
                    if(validCode(FIRE,encrypt("DRAGON",6)))
                    {   if(flagfire)
                        Allies.add("FIRE");
                        flagfire=false;
                    }
                    break;
                case "ICE":
                    ICE=sc.nextLine();
                    if(validCode(ICE,encrypt("MAMMOTH",7)))
                    {   if(flagice)
                        Allies.add("ICE");
                        flagice=false;
                    }
                    break;
            }

        }
        int size=Allies.size();
        if(size>3)
        {
            for(String s:Allies)
            {
                System.out.print(s+" ");
            }
        }
        else
        {
            System.out.print("NONE");
        }
      
    }
     public static String encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        String resString=result.toString();
        return resString;
    }
    public static boolean validCode(String msg,String code)
    {
        int index;
        StringBuilder sb=new  StringBuilder(msg);
        for(int i=0;i<code.length();i++)
        {   char ch=code.charAt(i);
            index=sb.indexOf(Character.toString(ch));
            if(index==-1)
            {
                return false;
            }
            else
            { 
                sb=sb.deleteCharAt(index);
            }
        }
        return true;

    }
}