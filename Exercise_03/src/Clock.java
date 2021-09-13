public class Clock {
   //instance variables
   private int h;
   private int min;

   // getter and setter
   public void setMin() {
      this.min=0;
   }
   public void setH() {
      this.h=0;
   }
   public int getMin() {

      return min;
   }
   
   public int getH() {

      return h;
   }


   // 3 constructors added
   public Clock(int hr,int m){
      this.h=hr;
      this.min=m;

   }
   public Clock(int m) //only the minutes since midnight (here possibly much larger than 60)
   {
      if (m <60 ) {
         this.min = m;
      }
      else {
         this.min = m % 60;
         h = (m - this.min) / 60;
         if (h >23) {
            h = h-24;
         }
      }

   }
   public Clock(String hr_m){

      h = Integer.parseInt(hr_m.split(":")[0]);
      min = Integer.parseInt(hr_m.split(":")[1]);
   }

   // the (overloaded) methods
   
   public Clock add(int minute) {
      int total_min=(h*60)+min+minute;
      Clock time1=new Clock(total_min);
      return time1;

   }
   public Clock add(Clock c) {
      int total_min=(h*60)+(c.h * 60) +min+c.min;
      Clock time2=new Clock(total_min);
      return time2;

   }
   
   public String toString() {
      String output;
      String m_value;
      String h_value;
      if (min<10)
         m_value= "0"+Integer.toString(min);
     else
         m_value=Integer.toString(min);
      h_value=Integer.toString(h);
      output=h_value+":"+m_value;
      return output;
   }
   public static void main(String[] args) {
      Clock c1,c2,c3, c4,c5;// declare variables
      c4 = new Clock("22:32");// create an object and assign a reference
      c5 = c4.add(517);// calling add method
      c1 = new Clock("0:30");
      c2 = new Clock("10:00");
      c3 = c1.add(c2);// calling add method
      System.out.println(c4.toString());
      System.out.println(c5.toString());
      System.out.println(c1.toString());
      System.out.println(c2.toString());
      System.out.println(c3.toString());



   }
}
