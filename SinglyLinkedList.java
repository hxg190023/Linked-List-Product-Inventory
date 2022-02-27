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
class SinglyLinkedList<AnyType extends IDedObject>
 */
public class SinglyLinkedList<AnyType extends IDedObject>
{
    // Node class
    class Node
    {
        // Creating AnyType dataObject and
        // the next node pointer.
        private AnyType dataObject;
        private Node next;

        // 2-arg Constructor that takes the object and the next node pointer as arguments
        public Node(AnyType dataObject, Node next)
        {
            this.dataObject = dataObject;
            this.next = next;
        }

        // Getter for dataObject
        public AnyType getData()
        {
            // Will return the dataObject
            return dataObject;
        }

        // Setter for dataObject
        // Takes dataObject as argument
        public void setData(AnyType dataObject)
        {
            this.dataObject = dataObject;
        }

        // Getter for next node pointer
        public Node getNextNode()
        {
            // Will return the next node pointer
            return next;
        }

        // Setter for next node pointer
        // Takes next node pointer as argument
        public void setNextNode(Node next)
        {
            this.next = next;
        }

    } // end of class Node

    // Head node created
    private Node head;

    /*
    Will empty the linked list by making the head = null.
     */
    public void makeEmpty()
    {
        head = null;

    } // end of method makeEmpty()

    /*
    Will find a specific ID by taking that ID as an argument.
    If the ID is found, the method will get the generic type (AnyType)
    and return the object of AnyType.
    Else, if the list is empty or the ID cannot be found, the method will return null.
    The method will not remove the ID from the linked list.
     */
    public AnyType findID(int ID)
    {

        // If linked list is empty
        if (head == null)
        {
            return null;
        }

        // thisNode is initialized to head to iterate through the linked list
        Node thisNode = head;

        // AnyType object that will be returned is declared
        AnyType returnAnyType;

        // Iterate through entire linked list
        while (thisNode != null)
        {
            // If found a matching ID
            if (thisNode.getData().getID() == ID)
            {
                // Will return the returnAnyType
                returnAnyType = thisNode.getData();
                return returnAnyType;
            }

            // Will point to the next node
            thisNode = thisNode.getNextNode();
        }

        // Will return null if it cannot be found
        return null;

    } // end of AnyType findID(int ID)

    /*
    Will insert the node at the front of the linked list and return true.
    If the node is already there then the method will return false.
     */
    public boolean insertAtFront(AnyType x)
    {
        // The newNode will have the x AnyType data and point to null.
        Node newNode = new Node(x, null);

        // findNode will be used to iterate through the linked list
        // to find a possible match already located in the linked list.
        Node findNode = head;

        // Will be used to determine if a match is found
        boolean findMatch = false;

        // If the linked list is empty,
        // the head becomes the newNode, and program will return true.
        if (head == null)
        {
            head = newNode;
            return true;
        }
        // Iterate through to find a match
        else
        {
            // Will iterate through linked list to find a possible match
            while (findNode != null)
            {
                // If match is found, the method will return false.
                // Cannot add same product twice.
                if (findNode.getData().getID() == x.getID())
                {
                    findMatch = true;
                    return false;
                }

                // Will point to the next node
                findNode = findNode.getNextNode();
            }
        }

        // Will only happen if head != null and not a match
        if (head != null && findMatch == false)
        {
            // If a head already exists, and there exist no product already there
            // then the program will make the newNode pointer the head.
            newNode.setNextNode(head);

            // The head will become the newNode.
            head = newNode;
        }

        // Will return true if Node is not head and a match cannot be found
        return true;

    } // end of boolean insertAtFront(AnyType x)

    /*
    Will delete the product at the front of the linked list.
    If list is empty, then will return null.
     */
    public AnyType deleteFromFront()
    {
        // Will be used to return the record of the data
        AnyType record;

        // If head is null (list is empty),
        // will return null
        if (head == null)
        {
            return null;
        }
        // If head is not empty, then the program will adjust the head and pointer
        else
        {
            // Will return the record of the first item
            record = head.getData();

            // The head is adjusted to point to the next node
            head = head.getNextNode();
        }

        // Will return the record at the front of the list
        return record;

    } // end of AnyType deleteFromFront()

    /*
    Will delete the particular ID from the linked list,
    and will return null if the ID cannot be found or if the list is
    empty.
     */
    public AnyType delete(int ID)
    {
        // Will be used to return the record of the data
        AnyType record;

        // The currentNode will be initialized to the head
        Node currentNode = head;

        // If the head == null, then the linked list is empty
        // Will return null
        if (head == null)
        {
            return null;
        }

        // If the currentNode is != null and the ID matches
        // If head is the matched ID
        if (currentNode != null && head.getData().getID() == ID)
        {
            // The head node will be stored in record
            record = head.getData();

            // head node will be adjusted to link to next
            head = head.getNextNode();

            // The record is returned to main method
            return record;
        }
        // Will loop through the remaining list to find a possible match
        else
        {
            // The tempNode will point to the head's pointer (next)
            Node tempNode = head.getNextNode();

            // Initialized to null to start iteration again
            record = null;

            // Will loop until a match is found
            while (tempNode != null && tempNode.getData().getID() != ID)
            {
                // currentNode is now the tempNode
                currentNode = tempNode;

                // Point to next tempNode
                tempNode = tempNode.getNextNode();
            }

            // If a match is found the record is stored, the tempNode
            record = tempNode.getData();

            // The currentNode is set to the tempNode
            currentNode.setNextNode(tempNode.getNextNode());
        }

        // Will return the record of the deleted variable
        return record;

    } // end of AnyType delete(int ID)

    /*
    Will print all the products in the linked list.
    Will print that the linked list is empty if the head == null.
     */
    public void printAllRecords()
    {
        // Will be used to print all nodes in the linked list.
        // Initialized to the head.
        Node printNode = head;

        // If linked list is empty
        if (head == null)
        {
            System.out.println("\nLinked List is empty.\n");
        }
        // Will iterate linked list
        else
        {
            // Will iterate entire linked list
            while (printNode != null)
            {
                System.out.println("");
                // Print the print ID method for each node
                printNode.getData().printID();
                System.out.println("");

                // Will point to the next node to print next
                printNode = printNode.getNextNode();
            }
        }

    } // end of void printAllRecords()

} // end of class SinglyLinkedList<AnyType extends IDedObject>