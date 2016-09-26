/**
*In this example SingleSpoon class holds one instance of SingleSpoon in "private static SingleSpoon theSpoon;". 
The SingleSpoon class determines the spoons availability using "private static boolean theSpoonIsAvailable = true;" 
The first time SingleSpoon.getTheSpoon() is called it creates an instance of a SingleSpoon. 
The SingleSpoon can not be distributed again until it is returned with SingleSpoon.returnTheSpoon(). 
***/

public class SingleSpoon 
{  
   private Soup soupLastUsedWith;
   
   private static SingleSpoon theSpoon;
   private static boolean theSpoonIsAvailable = true;
   
   private SingleSpoon() {}
     
   public static SingleSpoon getTheSpoon() {
       if (theSpoonIsAvailable) {
           if (theSpoon == null) {
               theSpoon = new SingleSpoon();
           }
           theSpoonIsAvailable = false;
           return theSpoon;
       } else {
           return null;
           //spoon not available, 
           //  could throw error or return null (as shown)
       }
   }
    
   public String toString() {
       return "Behold the glorious single spoon!";
   }
    
   public static void returnTheSpoon() {
       theSpoon.cleanSpoon();
       theSpoonIsAvailable = true;
   }     
   
   public Soup getSoupLastUsedWith() {
       return this.soupLastUsedWith;
   }
   public void setSoupLastUsedWith(Soup soup) {
       this.soupLastUsedWith = soup;
   }


   public void cleanSpoon() {
       this.setSoupLastUsedWith(null);
   }   
}


class TestSingleSpoon {
    
   public static void main(String[] args) {
       System.out.println("First person getting the spoon");
       SingleSpoon spoonForFirstPerson = 
         SingleSpoon.getTheSpoon();
       if (spoonForFirstPerson != null)
           System.out.println(spoonForFirstPerson);
       else
           System.out.println("No spoon was available");
       
       System.out.println("");
       
       System.out.println("Second person getting a spoon");
       SingleSpoon spoonForSecondPerson = SingleSpoon.getTheSpoon();
       if (spoonForSecondPerson != null)
           System.out.println(spoonForSecondPerson);
       else
           System.out.println("No spoon was available");
       
       System.out.println("");
       
       System.out.println("First person returning the spoon");
       spoonForFirstPerson.returnTheSpoon();       
       spoonForFirstPerson = null;
       System.out.println("The spoon was returned");
       
       System.out.println("");
       
       System.out.println("Second person getting a spoon");
       spoonForSecondPerson = SingleSpoon.getTheSpoon();
       if (spoonForSecondPerson != null)
           System.out.println(spoonForSecondPerson);
       else
           System.out.println("No spoon was available");
   }
}
