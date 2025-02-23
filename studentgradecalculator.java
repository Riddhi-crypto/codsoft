import java.util.Scanner;
class studentgradecalculator {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("enter number of subjects");
        int snumber=scn.nextInt();
        int totalmarks=0;
        for(int i=1;i<=snumber;i++){
            System.out.println("Enter subject marks "+i+" out of 100");
            int marks=scn.nextInt();
            totalmarks=totalmarks+marks;
        }
         
         double percentage=totalmarks/snumber;
         System.out.println(totalmarks +" out of "+(snumber*100));
         System.out.println(percentage+"%");
         if(percentage>=90){
            System.out.println("You secured Grade A");
         }
         else if(percentage>=80){
            System.out.println("You secured Grade B");
         }
         else if(percentage>=70){
            System.out.println("You secured Grade C");
         }
         else if(percentage>=60){
            System.out.println("You secured Grade D");
         }
         else
         System.err.println("You secured Grade F");
    }
}