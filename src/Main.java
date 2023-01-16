import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        day_keeper();
    }

    public static void day_keeper(){
        Scanner scan1 = new Scanner(System.in);

        System.out.print("Enter a date as year/month/days (YYYY/MM/DD) format : ");
        String date = scan1.nextLine();

        String year = date.substring(0,4);
        int intYear = Integer.parseInt(year);

        String month = date.substring(5,7);
        int intMonth = Integer.parseInt(month);

        String day = date.substring(8,10);
        int intDay = Integer.parseInt(day);

        /*
            This is the way to validate user inputs to check
            input date is in the correct date range and also
            discard inputs which are not valid
         */

        if(intYear < 1900 || intYear > 2100){
            //Exit Out of bound
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Invalid input..!\nPlease Enter a date in the 1900-03-xx to 2100-02-xx range..\n\n");
            day_keeper();
        } else if (intMonth < 1 || intMonth > 12) {
            //Exit Month
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Invalid input..!\nMonth should be in the range of 1 to 12..\n\n");
            day_keeper();
        } else if (intDay < 1 || intDay > 31) {
            //Exit Day
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Invalid input..!\nDate should be in the range of 1 to 31..\n\n");
            day_keeper();
        } else {
            if(intYear == 1900 && intMonth < 3) {
                //Exit Out of bound
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Invalid input..!\nPlease Enter a date in the 1900-03-xx to 2100-02-xx range..\n\n");
                day_keeper();
            } else if (intYear == 2100 && intMonth > 2) {
                //Exit Out of bound
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Invalid input..!\nPlease Enter a date in the 1900-03-xx to 2100-02-xx range..\n\n");
                day_keeper();
            } else {
                int days = ((intYear-1900)*365)+(intYear-1900)/4;
                if(intYear%4==0 && (intMonth==1 ||intMonth==2)){
                    days = days - 1;
                }

                int temp=0;
                for(int i=1; i<intMonth; i++){
                    if(i == 1 || i == 4 || i == 6 || i == 9  || i ==11){
                        temp = temp + 30;
                    } else if(i == 2){
                        temp = temp + 28;
                    } else{
                        temp = temp + 31;
                    }
                }

                days = days + temp + intDay;

                System.out.println("\n" + date + " is a ");

                if(days%7==0){
                    System.out.println("Sunday");
                } else if(days%7==1){
                    System.out.println("Monday");
                } else if(days%7==2){
                    System.out.println("Tuesday");
                } else if(days%7==3){
                    System.out.println("Wednesday");
                } else if(days%7==4){
                    System.out.println("Thursday");
                } else if(days%7==5){
                    System.out.println("Friday");
                } else{
                    System.out.println("Saturday");
                }
            }
        }
    }
}