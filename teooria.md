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





# arithmetic, logic, unary operators

## arithmetic operators
When operationg on different types, java will typecast everything to highest type.
order: byte → short → int → long → float → double

operations          + - * / %
x-equal operations  += -= *= /= %=

## logic operators

!   not
&&  and
||  or

## unary operators
Unary operators can be used as prefix or suffix

x++ increment after using x
++x increment before using x

+   convert to positive
-   change sign (+-)
++  autoincrement by 1
--  autodecrement by 1





# Math class
Every function has a prefix of Math.

PI                  pi constant
E                   e constant
random()            returns random double from [0, 1)


round(x)            mathematican round > int
ceil(x)             rounds up > int
floor(x)            rounds down > int

max(x, y)           returns max provided value        
min(x, y)           returns min provided value

## math operators
abs(x)              absolute value
signum(x)           returns 1, -1 or 0 based on x's sign
copySign(x, y)      returns x with the sign of y

pow(x, y)           x^y
sqrt(x)             square root
cbrt(x)             cube root
hypot(x, y)         calculates hypotenuse sqrt(x² + y²)
log10(x)            log base 10
log(x)              ln x (natural logarithm)
exp(x)              e^x

toRadians(deg)      convert deg > rad
toDegrees(rad)      convert rad > deg

## exact methods
will have an exeption in case of overflow

addExact(x, y)          addition
subtractExact(x, y)     subtraction
multiplyExact(x, y)     multiplication

incrementExact(x)       increment by 1
decrementExact(x)       decrement by 1
negateExact(x)          change sign
toIntExact(x)           long > int typecast

## floating point / binary (IEEE) methods

ulp(x)                  returns the smallest step value to reach the next number value
getExponent(x)          returns IEEE exponent

nextUp(x)               returns next number value
nextDown(x)             returns previous number value
nextAfter(x, y)         returns next value when moving x > y

scalb(x, n)             returns x * 2^n (faster than regular arithmetic)





# String methods
String methods are used to manipulate strings

String text = "abc"
all methods will have a prefix of "text."

length()    > int           length of the string 
isEmpty     > boolean       returns true if length(str) = 0
isBlank()   > boolean       returns true if string is empty or consists of spaces

equals(x)   > boolean       returns true if text is identical to x





# Print statement (System.out.println)
Supports only one variable, can be given multiple by adding them together as one:

System.out.println();   // prints as a separate row
System.out.print();     // prints in-line
System.out.printf();    // formatted output


System.out.println(arg1 + arg2);
System.out.println("str" + arg + " " + arg2);

Sisendiks võib olla ka non-string andmetüüp, sel juhul see typecastitakse funktsioonis automaatselt.





# Printf() - f-string in java
System.out.printf(str, var1, var2, ...);
When using variables in f-string, you need to provide them in-order as additional arguments
inline, doesn't provide \n

str format:
%[flags][width][.precision][specifier-character]

## flags
%s      string, any - toString() will be used
%d      int, byte, short, long, BigInteger
%f      float, double, BigDecimal
%c      char, unicode as integer
%b      boolean, any (null > false, other > true)


%.2f    round to 2 decimal places
%+f     show +- sign
%,f     comma grouping separator
%(f     enclose negative numbers in ()
% f     precede positive numbers with space

%n      line break

%04d    zero-pad to 4 digits
%4d     right-justified padding to 4 digits
%-4d    left-justified padding to 4 digits

## Examples:
String name = "Tim";
char firstletter = name.charAt(0);
int age = 20;
double height = 20.3;

System.out.printf("Hello, %s.\nYour name starts with a %c.\n", name, firstletter);
System.out.printf("You are %d years old and about %.0f meters tall", age, height);





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






# For/while loops

for(start; condition; end;){
    ...
}

// example: start at i=7 with autodecrement while x == true
// i++ autoincrement, i-- autodecrement

for(i = 17; x && true; i--) i = 17{
    ...
}




