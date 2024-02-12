import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

void main() throws IOException, InterruptedException {
    String names = "";
    String OOPMarks = "", stTotal = "";
    String PFMarks = "";
    String IDs = "";
    String lowestID = "";
    String highestID = "";
    int nOfStudents = 0, lowestMarks = 200, highestMarks = 0;
    final String BLUE = "\033[34;1m";
    final String RESET = "\033[0m";
    Scanner SCANNER = new Scanner(System.in);
    main:
    while (true) {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        System.out.println("================================");
        System.out.println("     WELCOME TO STUDENT DB");
        System.out.println("================================");
        System.out.println("1. Add new student");
        System.out.println("2. Delete Student");
        System.out.println("3. View all students");
        System.out.println("4. Search Student");
        System.out.println("5. Exit");
        System.out.print("Enter your command >");

        switch (SCANNER.nextInt()) {
            case 1 -> {
                c1:
                while (true) {
                    int total = 0;
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("================================");
                    System.out.println("       Add new students");
                    System.out.println("================================");
                    System.out.print("Enter Student name :");
                    SCANNER.skip("\n");
                    String name = SCANNER.nextLine();
                    if (name.isBlank()) System.out.println("Invalid name");
                    else {
                        nOfStudents = nOfStudents + 1;
                        String id = String.format("S%03d", nOfStudents);
                        System.out.println("Student ID:" + id);
                        IDs = IDs + id + ",";
                        names = names + id + name.strip() + "#" + id;

                        while (true) {
                            System.out.println("Enter the marks for Programming Fundamentals:");
                            int s1 = SCANNER.nextInt();
                            if (s1 < 0 || s1 > 101) System.out.println("Invalid marks..!..Try again..");
                            else {
                                total = total + s1;
                                PFMarks = PFMarks + id + s1 + "#" + id;
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("Enter the marks for OOP systems:");
                            int s2 = SCANNER.nextInt();
                            if (s2 < 0 || s2 > 101) System.out.println("Invalid marks..!..Try again..");
                            else {
                                total = total + s2;
                                OOPMarks = OOPMarks + id + s2 + "#" + id;
                                stTotal = stTotal + id + total + "#" + id;

                                if (highestMarks < total) {
                                    highestMarks = total;
                                    highestID = id;
                                }
                                if (lowestMarks > total) {
                                    lowestMarks = total;
                                    lowestID = id;
                                }
                                while (true) {
                                    System.out.println("Added Sucessfully!\n Do you want to add another student?{y/n)");
                                    String r = SCANNER.next();
                                    if (r.equals("y")) continue c1;
                                    else if (r.equals("n")) continue main;
                                    else System.out.println("Invalid response!..Try gain");
                                }
                            }
                        }
                    }
                }
            }

            case 2 -> {
                c2:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("================================");
                    System.out.println("      Delete students");
                    System.out.println("================================");
                    System.out.print("Enter Student ID to delete: ");
                    SCANNER.skip("\n");
                    String id = SCANNER.nextLine();
                    if (IDs.contains(id)) {
                        IDs = IDs.replace(id, "");
                        names = names.replace(names.substring(names.indexOf(id), names.indexOf("#" + id) + 5), "");
                        OOPMarks = OOPMarks.replace(OOPMarks.substring(OOPMarks.indexOf(id), OOPMarks.indexOf("#" + id) + 5), "");
                        PFMarks = PFMarks.replace(PFMarks.substring(PFMarks.indexOf(id), PFMarks.indexOf("#" + id) + 5), "");
                        stTotal = stTotal.replace(stTotal.substring(stTotal.indexOf(id), stTotal.indexOf("#" + id) + 5), "");
                        System.out.println(names);
                        // nOfStudents = nOfStudents - 1;
                        System.out.println("Deleted sucessfully!\n Do you want to delete more name?(y/n)");
                        String r = SCANNER.next();
                        if (r.equals("y")) ;
                        else if (r.equals("n")) continue main;
                        else System.out.println("Invalid response !");
                    } else {
                        System.out.println("ID Notfound!!\n Do you want to delete any other ?(y/n)");
                        String r = SCANNER.next();
                        if (r.equals("y")) ;
                        else if (r.equals("n")) continue main;
                        else System.out.println("Invalid response");
                    }


                }
            }
            case 3 -> {
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("================================");
                    System.out.println("      All Student Details");
                    System.out.println("================================");


                    int nameWidth = 4;
                    if (nOfStudents != 0) {
                        for (int i = 1; i <= nOfStudents; i++) {

                            String id = String.format("S%03d", i);
                            if (IDs.contains(id)) {
                                String name = names.substring(names.indexOf(id) + 4, names.indexOf("#" + id));
                                if (nameWidth < name.length() + 2) nameWidth = name.length() + 2;
                            }
                        }

                        final String ROW = STR."|%-\{6}s|%-\{nameWidth}s|%-\{7}s|%-\{5}d|%-\{8}s|\n";


                        final String line = "+" + "-".repeat(6) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(7) + "+" + "-".repeat(5) + "+" + "-".repeat(8) + "+";
                        System.out.println(line);
                        System.out.printf(STR."|\{BLUE}%-\{6}s\{RESET}|\{BLUE}%-\{nameWidth}s\{RESET}|\{BLUE}%-\{7}s\{RESET}|\{BLUE}%-\{5}s\{RESET}|\{BLUE}%-\{8}s\{RESET}|\n", " ID", "NAME", "TOTAL", "AVG", "STATUS");
                        System.out.println(line);

                        int z = 0;
                        while (z++ < nOfStudents) {
                            String ID_d = String.format("S%03d", z);
                            if (IDs.contains(ID_d)) {
                                String Name_d = names.substring(names.indexOf(ID_d) + 4, names.indexOf("#" + ID_d));
                                String Total_d = stTotal.substring(stTotal.indexOf(ID_d) + 4, stTotal.indexOf("#" + ID_d));
                                int avg = (Integer.parseInt(Total_d)) / 2;
                                String status = avg > 75 ? "A" : avg > 65 ? "B" : avg > 55 ? "C" : avg > 40 ? "S" : "F";
                                System.out.printf(ROW, ID_d, Name_d, Total_d, avg, status);

                            }
                        }
                        System.out.println(line);
                        System.out.println("Student With Lowest Mark:" + lowestID);
                        System.out.println("Student With Highest Mark:" + highestID);
                        continue main;
                    } else {
                        System.out.println("No Students to display!");
                        continue main;
                    }
                }
            }

            case 4 -> {
                c2:
                while (true) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                    System.out.println("================================");
                    System.out.println("      Search students");
                    System.out.println("================================");
                    System.out.print("Enter Student ID to Search: ");
                    SCANNER.skip("\n");
                    String id = SCANNER.nextLine();
                    String name, s1Mark, s2Mark, total;
                    if (IDs.contains(id)) {
                        name = names.substring(names.indexOf(id) + 4, names.indexOf("#" + id));
                        s1Mark = OOPMarks.substring(OOPMarks.indexOf(id) + 4, OOPMarks.indexOf("#" + id));
                        s2Mark = PFMarks.substring(PFMarks.indexOf(id) + 4, PFMarks.indexOf("#" + id));
                        total = stTotal.substring(stTotal.indexOf(id) + 4, stTotal.indexOf("#" + id));
                        int avg = (Integer.parseInt(total)) / 2;
                        String status = avg > 75 ? "A" : avg > 65 ? "B" : avg > 55 ? "C" : avg > 40 ? "S" : "F";
                        System.out.println("STUDENT DETAILS");
                        System.out.printf(STR."ID:\{BLUE}%s\{RESET}\nNAME:\{BLUE}%s\{RESET}\nTOTAL:\{BLUE}%s\{RESET}\nAVG:\{BLUE}%s\{RESET}\nPF MARKS:\{BLUE}%s\{RESET}\nOOP MARKS:\{BLUE}%s\{RESET}\nGRADE:\{BLUE}%s\{RESET}\n", id, name, total, avg, s1Mark, s2Mark, status);
                        System.out.print(" Do you want to search more names?(y/n)");
                        String r = SCANNER.next();
                        if (r.equals("y")) ;
                        else if (r.equals("n")) continue main;
                        else System.out.println("Invalid response !");
                    } else {
                        System.out.print("ID Notfound!!\n Do you want to delete any other ?(y/n)");
                        String r = SCANNER.next();
                        if (r.equals("y")) ;
                        else if (r.equals("n")) continue main;
                        else System.out.println("Invalid response");
                    }


                }
            }

            case 5 -> System.exit(0);
            default -> System.out.println("Invalid response");
        }
    }
}
