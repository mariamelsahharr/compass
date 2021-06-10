package com.company;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        boolean ft = true;
        while (ft) {

            System.out.println("(1) convert bearing to compass\n" +
                    "(2) convert compass to bearing\n" +
                    "Choose:");

            int ask = input.nextInt();
            int inp = 0;
            String direc = "";
            String direc2 = "";
            String outp;
            int deg = 0;


            if (ask == 1) {
                System.out.println("Bearing:");
                inp = input.nextInt();
                outp = "Bearing " + inp + " is";

                if (inp >= 0 && 359 >= inp) {

                    if (45 >= inp || inp >= 315) {

                        direc = "N";
                        outp = outp + " " + direc;
                    } else if (134 >= inp) {
                        direc = "E";
                        outp = outp + " " + direc;
                    } else if (225 >= inp) {
                        direc = "S";
                        outp = outp + " " + direc;
                    } else {

                        direc = "W";
                        outp = outp + " " + direc;
                    }

                } else {
                    outp += " invalid";

                }

                switch (direc) {

                    case "N":
                        if (45 > inp && inp > 0) {
                            deg = inp;
                            direc2 = "E";
                            outp = outp + deg + direc2;
                        }
                        else if(inp==0){
                            deg=0;
                            outp = outp;
                        }
                        else if (inp == 45) {
                            direc2 = "E";
                            outp += direc2;
                        } else if (inp == 315) {
                            direc2 = "W";
                            outp += direc2;
                        } else if (inp > 315) {
                            deg = 360 - inp;
                            direc2 = "W";
                            outp += deg + direc2;
                        }

                        break;

                    case "E":
                        if (90 > inp) {
                            deg = 90 - inp;
                            direc2 = "N";
                            outp += deg + direc2;
                        } else if (inp >= 91) {
                            deg = inp-90;
                            direc2 = "S";
                            outp += deg + direc2;
                        }
                        else if(90==inp){
                            deg=90;

                        }
                        break;

                    case "S":
                        if (inp == 135) {
                            direc2 = "E";
                            outp += direc2;
                        }
                        else if (180 > inp && inp >= 136) {
                            deg = 180 - inp;
                            direc2 = "E";
                            outp += deg + direc2;
                        }
                        else if(180==inp){
                            deg=180;

                        }
                        else if (225 > inp && inp > 180) {
                            deg = inp-180;
                            direc2 = "W";
                            outp += deg + direc2;
                        } else if (inp == 225) {
                            direc2 = "W";
                            outp += direc2;
                        }
                        break;

                    case "W":
                        if (270 > inp) {
                            deg = 270 - inp;
                            direc2 = "S";
                            outp += deg + direc2;
                        }
                        if (270 == inp) {
                            deg = 270;

                        }
                        if (inp > 270) {
                            deg = inp-270;
                            direc2 = "N";
                            outp += deg + direc2;
                        }

                        break;
                }
                System.out.println(outp);

            } else if (ask == 2) {

                System.out.println("Compass direction:");

                String fullinp = input.next();
                String usein = null;
                int count = 0;


                for (int i = 0; i < fullinp.length(); i++) {
                    if (fullinp.charAt(i) != ' ')
                        count++;
                }
                if (count == 1) {

                    direc = Character.toString(fullinp.charAt(0));
                    usein=direc;
                } else if (count == 2) {

                    direc = Character.toString(fullinp.charAt(0));
                    direc2 = Character.toString(fullinp.charAt(1));
                    usein=direc+direc2;
                } else if (count == 3) {

                    direc = Character.toString(fullinp.charAt(0));
                    String strp1 = Character.toString(fullinp.charAt(1));
                    inp = Integer.parseInt(Character.toString(fullinp.charAt(1)));
                    direc2 = Character.toString(fullinp.charAt(2));
                    usein=direc+strp1+direc2;
                } else if (count == 4) {

                    direc = Character.toString(fullinp.charAt(0));
                    String strp1 = Character.toString(fullinp.charAt(1));
                    String strp2 = Character.toString(fullinp.charAt(2));
                    direc2 = Character.toString(fullinp.charAt(3));
                    String strp3 = strp1 + strp2;
                    inp = Integer.parseInt(strp3);
                    usein=direc+strp3+direc2;
                }
                direc = direc.toUpperCase();
                direc2 = direc2.toUpperCase();


                if ((45 > inp && inp >= 0) || (3 > count)) {
                    if (count == 2) {
                        outp = "Compass " + usein + " is a bearing of ";
                        if ((direc2.equals("W") && direc.equals("N")) || ((direc == ("W")) && direc2.equals("N"))) {
                            deg = 315;
                            outp += deg;
                            System.out.println(outp);
                        } else if ((direc2.equals("E") && direc.equals("N")) || ((direc == ("E")) && direc2.equals("N"))) {
                            deg = 45;
                            outp += deg;
                            System.out.println(outp);
                        }
                        else if ((direc2.equals("E") && direc.equals("S")) || ((direc == ("E")) && direc2.equals("S"))) {
                            deg = 135;
                            outp += deg;
                            System.out.println(outp);
                        }
                        else if ((direc2.equals("W") && direc.equals("S")) || ((direc == ("W")) && direc2.equals("S"))) {
                            deg = 225;
                            outp += deg;
                            System.out.println(outp);
                        }
                        else {
                            System.out.println("Compass "+usein +" is invalid");
                        }
                    } else if (count != 2) {
                        outp = "Compass " + direc + inp + direc2 + " is a bearing of ";
                        switch (direc) {
                            case "N":
                                if (direc2.equals("E")) {
                                    outp += inp;
                                    System.out.println(outp);
                                } else if (direc2.equals("W")) {
                                    deg = 360 - inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (count == 1) {
                                    deg = 0;
                                    outp += deg;
                                    System.out.println(outp);
                                    outp = "Compass " + direc + " is a bearing of ";
                                }
                                else{
                                    System.out.println("Compass "+ usein +" is invalid");
                                }
                                break;
                            case "E":
                                if (direc2.equals("N")) {
                                    deg = 90 - inp;
                                    outp += deg;
                                    System.out.println(outp);

                                } else if (direc2.equals("S")) {
                                    deg = 90 + inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (count == 1) {
                                    deg = 90;
                                    outp += deg;
                                    System.out.println(outp);
                                }
                                else{
                                    System.out.println("Compass "+ usein +" is invalid");
                                }
                                break;
                            case "S":
                                if (direc2.equals("W")) {
                                    deg = 180 + inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (direc2.equals("E")) {
                                    deg = 180 - inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (count == 1) {
                                    deg = 180;
                                    outp += deg;
                                    System.out.println(outp);
                                }
                                else{
                                    System.out.println("Compass "+ usein +" is invalid");
                                }
                                break;
                            case "W":
                                if (direc2.equals("S")) {
                                    deg = 270 - inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (direc2.equals("N")) {
                                    deg = 270 + inp;
                                    outp += deg;
                                    System.out.println(outp);
                                } else if (count == 1) {
                                    deg = 270;
                                    outp += deg;
                                    System.out.println(outp);
                                }
                                else{
                                    System.out.println("Compass "+ usein +" is invalid");
                                }
                                break;
                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }
                } else {
                    System.out.println( "Compass " +usein+" is invalid");
                }
            } else {
                System.out.println("Invalid - please enter valid choice");
            }
            System.out.println("Do another conversion? y/n: ");
            String yeno = input.next();


            if ((yeno.equals("Y")) || (yeno.equals("y"))) {
                ft = true;
            }
            else{
                ft =false;
                System.out.println("Goodbye.");
            }

        }

    }
}


