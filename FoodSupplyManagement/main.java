import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*; // Importing Libraries

public class main {
    public static void main(String[] args) {
        String user = ""; // Create string user
        Boolean logged_in = false; // creates boolean Logged_in with default value false for while loop

        while (!logged_in) { // Prompts when boolean Loggged_in = false

            Scanner input = new Scanner(System.in); // create scanner input
            cls();
            boxstring("\t\t  Food Supply Management System  \t\t");
            System.out.print("\n\nEnter Username: ");
            String username = input.nextLine(); // store next user input to string username
            System.out.print("Enter Password: ");
            String password = input.nextLine(); // store next user input to string password

            if (username.equals("admin") && password.equals("pass")) {
                user = "admin"; // Logical operator that assign String user admin if the condition is met
                logged_in = true;
            } else {
                user = "customer"; // assign customer value to string user
                logged_in = true;
            }
        }
        Scanner menu = new Scanner(System.in); // Create scanner menu
        String choice, cont = "y";
        while (cont.equalsIgnoreCase("y")) {

            cls();
            if (user == "admin") { // Checks user value and runs when the condition is met // if the user value is
                // admin
                boxstring("\t\t  Food Supply Management System  \t\t");
                System.out.println("\n\nLogged in as Admin...");
                System.out.println("\n\n(1) Add a New Product");
                System.out.println("(2) View All Listed Products");
                System.out.println("(3) Search A Product By ID or Name");
                System.out.println("(4) Update A Product By ID ");
                System.out.println("(5) Delete A Product By ID");
                System.out.println("(6) Return TO Login Page ");
            } else {
                boxstring("\t\t  Food Supply Management System  \t\t"); // if the user value is customer
                System.out.println("\n\nInvalid username or password Logged in as Guest...");
                System.out.println("\n\n(1) View All Listed Products");
                System.out.println("(2) Search An Product By ID ");
                System.out.println("(3) Return TO Login Page ");
            }
            System.out.println("\n\n");
            System.out.println("Enter a choice to proceed: ");
            choice = menu.next(); // The user input will assign the value to String Choice
            if (user == "admin") { // the program will only run theese if the user value is admin
                switch (choice) { // Checks the choice and runs it accordingly // Run Default when the choice is
                    // not valid
                    case "1":
                        try { // using try catch block to handle Exceptions
                            cls(); // calls the method cls then Addrecord
                            Addrecord();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    break;
                        case "2":
                            try {
                                cls(); // calls the method cls then Viewrecord
                                Viewrecord();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    break;
                            case "3":
                                try {
                                    cls(); // calls the method cls then Searchrecord
                                    SearchRecord();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                    break;
                                case "4":
                                    try {
                                        cls(); // calls the method cls then UpdateData
                                        UpdateData();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                    break;
                                    case "5":
                                        try {
                                            cls();
                                            DeleteData(); // calls the method cls then DeleteData
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                    break;
                                        case "6":
                                            try {
                                                cls(); // calls the method then return to Main
                                                main(args);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                    break;
                                            default:
                                                cls(); // cls method then print
                    System.out.println("Please choose a valid option!!!");
                    System.out.println(" ");
                    break;

                }
            } else {
                switch (choice) {
                    case "1":
                        try {
                            cls(); // ganun lang din sa iba
                            Viewrecord();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    break;
                        case "2":
                            try {
                                cls();
                                SearchRecord();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    break;
                            default:
                                cls();
                                System.out.println("Please choose a valid option!!!");
                                System.out.println(" ");
                                break;
                                case "3":
                                    try {
                                        cls();
                                        main(args);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                    break;
                }
            }
            System.out.print("Do you want to continue? Y/N ");
            cont = menu.next();
        }
    }

    public static void cls() { // cls method clear the screen for windows
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void boxstring(String contents) { // boxstring method that needs string to run
        int n = contents.length();
        for (int i = 0; i < n + 28; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("|" + contents + "|");
        for (int i = 0; i < n + 28; i++) {
            System.out.print("-");
        }
    }

    public static void Addrecord() throws IOException { // add record method

        BufferedWriter bw = new BufferedWriter(new FileWriter("Database.txt", true)); // create database.txt if no file
        // found
        Scanner strinput = new Scanner(System.in); // create scanner strinput
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd//MM//yy"); // create date with format
        String date = sdf.format(new Date()); // add date to string date
        String ID, name, type, age, addr, price, date2; // declare variables

        boxstring("\t\t  Food Supply Management System  \t\t"); // calls boxstring to print the contents
        System.out.print("\n\nEnter Item ID: ");
        ID = strinput.nextLine(); // store the data to the respective variables ex: Enter item ID: to String ID
        System.out.print("Enter Product Name: ");
        name = strinput.nextLine();
        System.out.print("Enter Product Food Type: ");
        type = strinput.nextLine();
        System.out.print("Enter Product Quantity: ");
        age = strinput.nextLine();
        System.out.print("Enter Product Manufactured Date: ");
        date2 = strinput.nextLine();
        System.out.print("Enter Product Expiration Date: ");
        addr = strinput.nextLine();
        System.out.print("Enter Product Price: ");
        price = strinput.nextLine();

        bw.write(ID + ":::" + name + ":::" + type + ":::" + age + ":::" + date2 + ":::" + addr + ":::" + price + ":::"
                 + date); // calls buffered writter to write in txt file the stored data in the order
        // above
        bw.flush(); // flush the data
        bw.newLine(); // create a new line for next data
        bw.close(); // close the buffered writter
    }

    public static void Viewrecord() throws IOException { // viewrecord method

        BufferedReader br = new BufferedReader(new FileReader("Database.txt")); // create buffered reader bf
        String record; // create string record
        header(); // calls header
        while ((record = br.readLine()) != null) { // reads database.txt until its null and assign it to string record
            String[] data = record.split(":::"); // split record with ::: and assign it to string array data
            showrecord(data); // calls showrecord insides data
        }
        br.close(); // close buffered reader
    }

    public static void header() { // method header
        System.out.println(
                "____________________________________________________________________________________________________________________________________________________________________");
        System.out.print("|" + Padstring("ID", 5)); // calls padstring then add spaces depending on str length
        System.out.print("|" + Padstring("Product Name", 30)); // 30 spaces
        System.out.print("|" + Padstring("Food Type", 15)); // 15 and so on
        System.out.print("|" + Padstring("Quantity", 20));
        System.out.print("|" + Padstring("Manufactured date", 20));
        System.out.print("|" + Padstring("Expiration date", 20));
        System.out.print("|" + Padstring("Price", 20));
        System.out.print("|" + Padstring("Date Added", 20));

        System.out.println("|");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static String Padstring(String str, int num) { // padstring method
        int str_size = str.length(); // check for length
        for (int i = str_size; i <= num; i++) {
            str = str + " ";
        }
        return str; // returns str to padstring
    }

    public static void showrecord(String[] data) { // showrecord method
        System.out.print("|" + Padstring(data[0].toString(), 5)); // calls padstring then print the arrray data in
        // respective lines
        System.out.print("|" + Padstring(data[1].toString(), 30));
        System.out.print("|" + Padstring(data[2].toString(), 15));
        System.out.print("|" + Padstring(data[3].toString(), 20));
        System.out.print("|" + Padstring(data[4].toString(), 20));
        System.out.print("|" + Padstring(data[5].toString(), 20));
        System.out.print("|" + Padstring(data[6].toString(), 20));
        System.out.print("|" + Padstring(data[7].toString(), 20));
        System.out.println("|");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void SearchRecord() throws IOException {
        try {
            String search, record;
            Scanner str2Input = new Scanner(System.in); // new scanner

            BufferedReader br = new BufferedReader(new FileReader("Database.txt")); // reads database.txt

            boxstring("\t\t Searching An Item...    \t\t"); // calls boxstring for design
            System.out.println("\n\nEnter Item ID Or Item Name: ");
            search = str2Input.nextLine(); // store next line to string search

            header(); // call header method
            int i = 0;
            while ((record = br.readLine()) != null) { // ganun den sa kanina
                String[] data = record.split(":::");
                if (data[0].toString().equals(search) || data[1].toString().contains(search)) { // logical operator or
                    showrecord(data);
                    i++; // add value to i so i == 0 wont run
                }
            }
            if (i == 0) { // runs if no no data found
                cls();
                boxstring("\t\tNo Records Found \t\t");
                System.out.println("\n\n ");
            }

            br.close(); // close bufffered reader
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void DeleteData() throws IOException {
        try {
            Viewrecord();
            Scanner strInput = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd//MM//yy");
            String date = sdf.format(new Date());
            String ID, record;

            File tempDB = new File("tempdata.txt");
            File db = new File("Database.txt");

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            boxstring("\t\tDeleting An Item \t\t");
            System.out.println("\n\nEnter Item ID: ");
            ID = strInput.nextLine();
            int i = 0;
            int checker = 0;

            while ((record = br.readLine()) != null) {
                i++;
                String[] data = record.split(":::");
                if (data[0].toString().equals(ID))
                    continue;
                {
                    bw.write(record);
                    bw.flush();
                    bw.newLine();
                    checker++;
                }
            }
            if (checker == i) {
                cls();
                System.out.println("\n\n");
                boxstring("\t\tNo Data Found... \t\t");
                System.out.println("\n\n");
            } else {
                cls();
                boxstring("\t\t  Food Supply Management System  \t\t");
                System.out.println("\n\nSuccessfully Deleted ID number " + ID + " from the Database: " + date + "...");
            }
            br.close();
            bw.close();
            db.delete();
            tempDB.renameTo(db);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public static void UpdateData() throws IOException {
        try {
            Viewrecord();
            String newname, ID, newage, newaddr, newprice, record, newtype, newdate2;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd//MM//yy");
            String date = sdf.format(new Date());

            File db = new File("Database.txt");
            File tempDB = new File("tempdata.txt");

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            Scanner str4Input = new Scanner(System.in);

            System.out.println("\n\n");
            boxstring("\t\tUpdate Item Value\t\t");
            System.out.println("\n\n");
            System.out.println("Enter a Valid Item ID: ");
            ID = str4Input.nextLine();
            header();
            int i = 0;
            while ((record = br.readLine()) != null) {
                String[] data = record.split(":::");
                if (data[0].toString().equals(ID)) {
                    showrecord(data);
                    i++;
                } else {
                    cls();
                    System.out.println("\n\n");
                    boxstring("\t\tInvalid Entry!!! \t\t");
                    System.out.println("\n\n");
                }

            }
            br.close();
            if (i != 0) {
                cls();
                boxstring("\t\t  Food Supply Management System  \t\t");
                System.out.print("\n\nUpdate Product Name: ");
                newname = str4Input.nextLine();
                System.out.print("Update Product Food Type: ");
                newtype = str4Input.nextLine();
                System.out.print("Update Product Quantity: ");
                newage = str4Input.nextLine();
                System.out.print("Update Product Manufactured Date: ");
                newdate2 = str4Input.nextLine();
                System.out.print("Update Producct Expiration Date: ");
                newaddr = str4Input.nextLine();
                System.out.print("Update Product Price: ");
                newprice = str4Input.nextLine();

                BufferedReader br2 = new BufferedReader(new FileReader(db));

                while ((record = br2.readLine()) != null) {
                    String[] data = record.split(":::");
                    if (data[0].toString().equals(ID)) {
                        bw.write(ID + ":::" + newname + ":::" + newtype + ":::" + newage + ":::" + newdate2 + ":::"
                                 + newaddr + ":::" + newprice + ":::" + date);
                    } else {
                        bw.write(record);
                    }
                    bw.flush();
                    bw.newLine();
                }

                bw.close();
                br2.close();
                db.delete();
                tempDB.renameTo(db);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}