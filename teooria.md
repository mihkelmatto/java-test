# Java in-line comment
// one line comment
/* multiple line comment */
/** javadoc multiple line comment */

# Variables
Variable - a reusable container for a value
            a variable behaves as if it was the value it contains

## variable data types
Primitive - simple value stored directly in memory (stack)
- int, double, char, boolean
Reference - memory address (stack) that points to the value (heap)
- string, array, object


int x = 10;     
double x = 10.0;
char x = '!'
boolean x = true

String x = "abcde"



## steps to creating a variable
1. declaration
2. assignment

int x = 10;
or
int x;
x = 10;



# Print statement (System.out.println)
Supports only one variable, can be given multiple by adding them together as one:
System.out.println();   // prints as a separate row
System.out.print();     // prints in-line

System.out.println(arg1 + arg2);
System.out.println("str" + arg + " " + arg2);

Sisendiks võib olla ka non-string andmetüüp, sel juhul see typecastitakse funktsioonis automaatselt.



# User input (scanner)
import java.util.Scanner;

## scanner input types
System.in       // keyboard input
File            // file input
String          // string input

## scanner methods
- Assign to a variable:
type x = scanner.next_type();   // replace "type" with Int, Double, Long, Float, Boolean, ...
String x = scanner.next();      // reads an entire row
String x = scanner.nextLine();  // reads next word (separated by " " or "\n")

- Read input:
System.out.print("Enter input: ");
String input = scanner.nextLine();
System.out.println("Your input: " + input);

## creating a new scanner
/*
Scanner - class name
scanner - variable name
new Scanner - create a new scanner from class Scanner
*/

Scanner scanner = new Scanner(scanner_type);
.. insert scanner methods ..
scanner.close();    // close scanner