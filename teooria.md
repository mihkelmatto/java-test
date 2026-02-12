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

## typecasting
int x = 0;
float y = (float)(x);



# Print statement (System.out.println)
Supports only one variable, can be given multiple by adding them together as one:

System.out.println();   // prints as a separate row
System.out.print();     // prints in-line
System.out.printf();    // formatted output


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



# If-else statements

if(condition){
    ...
}
else if(condition){
    ...
}
else{
    ...
}

# operators
!x          not
a && b      and
a || b      or

a / b       division, type a > type a
a % b       remainder



# Math class
Math.PI
Math.E

Math.pow(int: x, int: y);       # x^y
Math.log10(a)                   # log base 10 of (a: double) 
Math.random();                  # returns double from [0, 1)

Math.round(double: x);          # returns int
Math.ceil(double: x);           # rounds up > int
Math.floor(double: x);          # rounds down > int

Math.max(double: x, double: y);             
Math.min(double: x, double: y);



# Printf
System.out.printf(str);

str format:
%[flags][width][.precision][specifier-character]



# For/while loops

for(start; condition; end;){
    ...
}

// example: start at i=7 with autodecrement while x == true
// i++ autoincrement, i-- autodecrement

for(i = 17; x && true; i--) i = 17{
    ...
}




