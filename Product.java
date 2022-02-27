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

/*
Product class implements IDedObject
 */
public class Product implements IDedObject
{
    // Class variables are declared as private
    private int productID;
    private String productName;
    private String supplierName;

    // 3-argument constructor
    // Constructor makes the variables members of the class
    // Using this to refer to the current object as a whole
    public Product (int productID, String productName, String supplierName)
    {
        this.productID = productID;
        this.productName = productName;
        this.supplierName = supplierName;

    } // end of Product (int productID, String productName, String supplierName)

    // Will return product ID
    // Overrides the abstract method in the interface
    @Override
    public int getID()
    {
        return productID;

    } // end of int getID()

    // Will print all variable values in separate lines
    // Overrides the abstract method in the interface
    @Override
    public void printID()
    {
        System.out.printf("%-16s%-24s\n", "Product ID Number: ", productID);
        System.out.printf("%-16s%-24s\n", "Product Name:      ", productName);
        System.out.printf("%-16s%-24s\n", "Supplier Name:     ", supplierName);

    } // end of void printID()

} // end of class Product implements IDedObject
