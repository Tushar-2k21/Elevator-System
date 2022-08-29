import java.util.Objects;
import java.util.Scanner;
class person{
    String person_name1;
    String person_name2;
    int person_des1;
    int person_des2;
    int person_cur1;
    int person_cur2;
}

class elevator extends Thread{
    void going_up() {
       try {
           System.out.println(" ...................  ELEVATOR GOING UP .....................");
           elevator.sleep(2100);
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
       }

    }
    void going_up1(String s) {
        try {
            System.out.println(" ...................  ELEVATOR GOING UP  with " + s + ".....................");
            elevator.sleep(2100);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    void going_down()
    {
        try {
            System.out.println("...................... ELEVATOR GOING DOWN.................");
            elevator.sleep(2100);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    void going_down1(String s)
    {
        try {
            System.out.println(" ...................  ELEVATOR GOING DOWN  with " + s + ".....................");
            elevator.sleep(2100);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
class floor extends Thread{
    void floor_reached(int a , int  b , String s)
    {
        try {
            floor.sleep(2100);
            System.out.println(" * PERSON " + s + " has REACHED from " + " FLOOR " + b + " to -->  " + a);
            System.out.println("...................NOW THE LIFT IS EMPTY...............");
            System.out.println(".");
            System.out.println(".");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    void floor_reached(int  a , int b)
    {
        try {
            floor.sleep(2100);
            System.out.println(" * EMPTY LIFT REACHED FLOOR " + b + " -> " + a);
            System.out.println("...................NOW THE LIFT IS EMPTY...............");
            System.out.println(".");
            System.out.println(".");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}

class systemm{



    int current_floor_of_lift;
}





public class IIT2021032_Elevator_program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        systemm sys = new systemm();
        elevator ele = new elevator();
        floor flo = new floor();
        person per = new person();
        sys.current_floor_of_lift = 1;


        while (true) {
            try {
                System.out.println("ENTER THE NAME OF PERSON");
                per.person_name1 = sc.next();

                System.out.println("ENTER ON CURRENT FLOOR " + per.person_name1 + " IS ON ");
                per.person_cur1 = sc.nextInt();


                System.out.println("ENTER ON DESTINATION FLOOR " + per.person_name1 + " WANTS TO GO ");
                per.person_des1 = sc.nextInt();

                if(per.person_cur1>2 || per.person_des1>2)
                {
                    throw new Exception();
                }
                if (Objects.equals(per.person_cur1, per.person_des1)) {
                    System.out.println("YOU ARE ALREADY ON THE THAT FLOOR");
                } else {
                    if (per.person_cur1 < sys.current_floor_of_lift) {
                        ele.going_down1(per.person_name1);

                        System.out.println("DO YOU WANT ANOTHER PERSON ON ANOTHER FLOOR. If yes print 1 if no then print 0 ");
                        int temp = sc.nextInt();
                        if (temp == 1) {
                            System.out.println(" ENTER THE NAME OF THE PERSON ");
                            per.person_name2 = sc.next();

                            System.out.println("ENTER ON CURRENT FLOOR " + per.person_name2 + " IS ON ");
                            per.person_cur2 = sc.nextInt();

                            System.out.println("ENTER ON DESTINATION FLOOR " + per.person_name2 + " WANTS TO GO ");
                            per.person_des2 = sc.nextInt();
                            if(per.person_cur2>2 || per.person_des2>2)
                            {
                                throw new Exception();
                            }

                            flo.floor_reached(per.person_des1, per.person_cur2, per.person_name1);
                            per.person_des1 = 0;
                            per.person_cur1 = 0;
                            per.person_name1 = null;
                            sys.current_floor_of_lift = per.person_des1;
                            if (per.person_des2 != sys.current_floor_of_lift) {
                                ele.going_up1(per.person_name2);
                                flo.floor_reached(per.person_des1, per.person_cur2, per.person_name2);
                            }

                            per.person_des2 = 0;
                            per.person_name2 = null;

                        }
                    } else if (Objects.equals(per.person_cur1, sys.current_floor_of_lift)) {
                        if (per.person_des1 > sys.current_floor_of_lift) {
                            ele.going_up1(per.person_name1);
//
                            System.out.println("DO YOU WANT ANOTHER PERSON ON ANOTHER FLOOR . If yes print 1 if no then print 0 ");
                            int temp = sc.nextInt();
                            if (temp == 1) {
                                System.out.println(" ENTER THE NAME OF THE PERSON ");
                                per.person_name2 = sc.next();

                                System.out.println("ENTER ON CURRENT FLOOR " + per.person_name2 + " IS ON ");
                                per.person_cur2 = sc.nextInt();

                                System.out.println("ENTER ON DESTINATION FLOOR " + per.person_name2 + " WANTS TO GO ");
                                per.person_des2 = sc.nextInt();
                                if(per.person_cur2>2 || per.person_des2>2)
                                {
                                    throw new Exception();
                                }
                                flo.floor_reached(per.person_des1, per.person_cur1, per.person_name1);

                                sys.current_floor_of_lift = per.person_des1;

                                if (per.person_des2 < sys.current_floor_of_lift && sys.current_floor_of_lift == per.person_cur2) {
                                    ele.going_down1(per.person_name2);
                                    flo.floor_reached(per.person_des2, per.person_cur2, per.person_name2);
                                }
                                else if (per.person_des2 == sys.current_floor_of_lift && per.person_cur2 < sys.current_floor_of_lift)
                                {
                                    ele.going_down();
                                    flo.floor_reached(per.person_des1, per.person_cur2);
                                    ele.going_up1(per.person_name2);
                                    flo.floor_reached(per.person_des2, per.person_cur2, per.person_name2);
                                }

                                sys.current_floor_of_lift = per.person_des2;
                                per.person_des1 = 0;
                                per.person_cur1 = 0;
                                per.person_name1 = null;
                                per.person_des2 = 0;
                                per.person_name2 = null;

                            }
                            else {
                                flo.floor_reached(per.person_des1, per.person_cur2, per.person_name1);
                            }
                        }
                    }
                    else {
                        ele.going_up();
//
                        System.out.println("DO YOU WANT ANOTHER PERSON ON ANOTHER FLOOR. If yes print 1 if no then print 0 ");
                        int temp = sc.nextInt();
                        if (temp == 1) {
                            System.out.println(" ENTER THE NAME OF THE PERSON ");
                            per.person_name2 = sc.next();

                            System.out.println("ENTER ON CURRENT FLOOR " + per.person_name2 + " IS ON ");
                            per.person_cur2 = sc.nextInt();

                            System.out.println("ENTER ON DESTINATION FLOOR " + per.person_name2 + " WANTS TO GO ");
                            per.person_des2 = sc.nextInt();
                            if(per.person_cur2>2 || per.person_des2>2)
                            {
                                throw new Exception();
                            }
                            flo.floor_reached(per.person_des1, per.person_cur1, per.person_name1);
                            sys.current_floor_of_lift = per.person_des1;


                            if (per.person_des2 > sys.current_floor_of_lift) {
                                ele.going_up1(per.person_name2);
                                flo.floor_reached(per.person_des2, per.person_cur2, per.person_name2);
                            }
                            per.person_des1 = 0;
                            per.person_cur1 = 0;
                            per.person_name1 = null;
                            per.person_des2 = 0;
                            per.person_name2 = null;
                            sys.current_floor_of_lift = per.person_des2;

                        }
                        else {
                            flo.floor_reached(per.person_des1, per.person_cur2, per.person_name1);
                        }
                    }
                }
            } catch (Exception e) {

                System.out.println("INVALID FLOOR NUMBER\n. PLEASE CHOOSE FROM FLOOR NUMBER 1 AND FLOOR NUMBER 2");
            }
        }
    }
}