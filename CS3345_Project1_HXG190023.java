/*
Name & NET-ID:      Harsh Gopalan (HXG190023)
Class & Section:    CS 3345. 004
Assignment:         Project 1 - Linked Lists

General Description of Program:
    - This program has 3 java files and 4 classes.
    - The IDedObject.java file has the abstract methods.
    - The SinglyLinkedList.java file has a few constructors and a series of methods that
      allow the program to do the necessary operations.
    - The node class is also located in the SinglyLinkedList.java file.
    - The Product.java file contains the contents of the abstract methods
      and necessary constructors.
    - The CS3345_Project1_HXG190023.java class contains the main method and is the driver of the program.

 */

import java.util.InputMismatchException;
import java.util.Scanner;

/*
class CS3345_Project1_HXG190023
 */
public class CS3345_Project1_HXG190023
{
    /*
    Will print the instructions.
     */
    public static void printInstructions()
    {
        // Instructions
        System.out.println("1. Make Empty");
        System.out.println("2. Find ID");
        System.out.println("3. Insert At Front");
        System.out.println("4. Delete From Front");
        System.out.println("5. Delete ID");
        System.out.println("6. Print All Records");
        System.out.println("7. Done\n");

    } // end of void printInstructions()

    /*
    Will take the listChoice and the scan as arguments to
    do input validation on the list choice.
    Will return the list choice back to the method call from main.
     */
    public static int inputValidation(int listChoice, Scanner scan)
    {
        // flag variable to determine input validation truth
        // initialized to true
        boolean flag = true;

        // Will run until only a valid integer value is entered by the user
        // Uses try-catch
        while (flag)
        {
            try
            {
                listChoice = scan.nextInt();
                flag = false;
            }
            // Will use an InputMismatchException to catch a non-integer input
            catch(InputMismatchException e)
            {
                System.out.println("Not an integer input.");
                scan.next();
            }
        }

        // Will return listChoice after a valid integer value is entered
        return listChoice;

    } // end of int inputValidation(int listChoice, Scanner scan)

    /*
    Main method
     */
    public static void main(String []args)
    {
        // Creating an object of SinglyLinkedList class
        SinglyLinkedList<Product> linkedList = new SinglyLinkedList<Product>();

        // do-while loop will run until the user selects option 7 from the list.
        do
        {

            // String variables are declared
            // Integer variables are declared and list choice is initialized to 0
            String supplierName, productName;
            int listChoice = 0, productID;

            // Scanner created with delimiter
            Scanner scan = new Scanner(System.in).useDelimiter("\\n");

            // Will call method to print the instructions
            printInstructions();

            // Ask user to choose valid option
            System.out.print("Choose one of the options. (Choose only options 1-7): ");

            // Will store list choice after input validation
            listChoice = inputValidation(listChoice, scan);

            // Switch Case for the 7 options
            switch (listChoice)
            {
                // Make empty
                // Will make the linked list empty
                case 1:
                    System.out.println("\nWill make the Linked List Empty.");

                    // Method call to makeEmpty
                    linkedList.makeEmpty();

                    System.out.println("Linked List was made empty.\n");
                    break;
                // Find ID
                // Will print all the details of the product ID if it is in the list.
                // If the method returned null, Will print the message.
                case 2:
                    // Ask user for ID and store in productID
                    System.out.print("Enter Product ID Number: ");
                    productID = scan.nextInt();

                    // Creating object of Product class to access findID method
                    // return value.
                    Product case2 = linkedList.findID(productID);

                    // If null, then print message
                    if (case2 == null)
                    {
                        System.out.println("\nThe Product ID cannot be found.\n");
                    }
                    // Else, will print the ID that was found
                    else
                    {
                        // Method call to printID
                        case2.printID();
                    }
                    break;
                // Insert At Front
                // Will get the product details from the user and add it to the front of the list
                case 3:
                    // Will ask user for all three input and store them in
                    // productID, productName, and supplierName, respectively.
                    System.out.print("Enter Product ID Number: ");
                    productID = scan.nextInt();
                    System.out.print("Enter Product Name: ");
                    productName = scan.next();
                    System.out.print("Enter Supplier Name: ");
                    supplierName = scan.next();

                    // Creating object of Product class to send to the 3-arg constructor.
                    Product classProduct = new Product(productID, productName, supplierName);

                    // Accessing the method
                    // If method returns false, then function will print message (cannot add)
                    if (linkedList.insertAtFront(classProduct) == false)
                    {
                        System.out.println("\nThis product already exists. The program cannot add duplicate products.\n");
                    }
                    // Else, Will let the user know it can add
                    else
                    {
                        System.out.println("\nThe following product has been added at the front.\n");
                    }
                    break;
                // Delete From Front
                // Will print the first item on the list and delete it.
                case 4:
                    // Creating an object of product class to access deleteFromFront() method return value
                    Product case4 = linkedList.deleteFromFront();

                    // If null, will let the user product cannot be found
                    if (case4 == null)
                    {
                        System.out.println("\nThis product cannot be found as list is empty.\n");
                    }
                    // Else, the product will be deleted from the front after it is printed.
                    else
                    {
                        System.out.println("\nThe following product will be deleted from the front.\n");

                        // Call to printID() to print the product
                        case4.printID();
                    }
                    break;
                // Delete ID
                // Will print the particular ID item and then delete it.
                case 5:
                    // Ask user for ID and store in productID
                    System.out.print("Enter Product ID Number: ");
                    productID = scan.nextInt();

                    // Create an object of Product class to access the delete ID method
                    IDedObject case5 = linkedList.delete(productID);

                    // If return value is null, then the product cannot be found.
                    if (case5 == null)
                    {
                        System.out.println("\nThis product cannot be found.\n");
                    }
                    // Else, the user will be told the product will be deleted, and it will be printed before.
                    else
                    {
                        System.out.println("\nThe following product will be deleted.\n");

                        // Call to printID() to print the product
                        case5.printID();
                    }
                    break;
                // Print All Records
                // Will print all records (products) in the linked list
                case 6:
                    // Method call to print all the records
                    linkedList.printAllRecords();
                    break;
                // Done (Quit Program)
                case 7:
                    System.out.println("\nProgram will now quit!\n");
                    return;
                // Input validation (Range check). List choice must be between 1-7
                default:
                    System.out.println("Enter a choice from the list only.");
            }

        } while (true);

    } // end of main(String []args)

} // end of class CS3345_Project1_HXG190023
