# IDE, Java tips

## Java in-line comment
// one line comment
/* multiple line comment */
/** javadoc multiple line comment */

## IDEA tricks
- psvm + [tab]                  generate public static void main
- sout + [tab]                  generate system.out.println();
- [alt] + [insert]              generate getters, setters
- [ctrl] + [space]              open suggestion menu

- reformat code                 can be used to horizontally refit code
- refactor-rename               can be used to mass rename/replace through the entire project



# Variables

## primitive data types
- Primitive - simple value stored directly in memory (stack)
- doesnt have methods
- uses less memory
- cant be null

// integer values
byte        8-bit         [-128, 127]   // 
short       16-bit      ~ [-32k, 32k]   // usually typecasted to int with arithmetic ops
int         32-bit      ~ [-2B, 2B]
long        64-bit      ~ [-2^63, 2^63] // suffix of L when using as non-variable

// floating point numbers
- inprecise, can give unexpected results with == operator
- can have values NaN (not a number), +-Infinity
float       32-bit      IEEE 754
double      64-bit      IEEE 754

// other
char 'x'    16-bit      unicode
var         will infer a type from its value

<Type>      generic type, used to write a class or method that can have multiple types
            have to use wrappers with primitive types

## reference data types
Reference - memory address (stack) that points to the value (heap)
- is an object
- x=y copies the address
- can't use == operator
- uses more memory
- can have an empty value (null)

String "x"      immutable   // + operator creates a new object, use stringbuilder or stringbuffer
StringBuilder   mutable, non-synchronized, faster
StringBuffer    mutable, synchronized, thread-safe

// list types
Array           static      indexing O(1)   search O(n)     ordered
ArrayList       dynamic     indexing O(1)   search O(n)     ordered
LinkedList      dynamic     indexing O(n)   search O(n)     ordered

// set types (all dynamic)
HashSet         add, remove, search: O(1)avg - O(n)         unordered, unique values
TreeSet         add, remove, search: O(log n)               ordered, sorted

// dict types (all dynamic)
HashMap         get, put, remove: O(n)avg - O(n)            unordered
LinkedHashMap   get, put, remove: O(n)avg - O(n)            ordered
TreeMap         get, put, remove: O(log n)                  ordered, keys sorted

## steps to creating a variable
1. declaration
2. assignment

int x = 10;
or
int x;
x = 10;





# typecasting

## implicit (automatic) - typecast when used
Order of typecasting (size)
- byte >> short >> int >> long >> float >> double
- char >> String

## explicit (manual)
primitive:
- (type)value


reference:
string > primitive              Type.parsetype(str)
primitive > string              String.valueOf(primitive) // use this when the value can be null
primitive wrapper > string      Type.toString(Primitive)
Object > String                 Obj.toString // needs to have a string representation



# arithmetic, logic, unary operators

## arithmetic operators
When operating on different types, java will typecast everything to highest type.
order: byte → short → int → long → float → double

operations          + - * / %           order: PEMDAS, left-to-right 
x-equal operations  += -= *= /= %=      order: right-to-left

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

## boolean values
length()    > int               length of the string 
isEmpty     > boolean           returns true if length(str) = 0
isBlank()   > boolean           returns true if string is empty or consists of spaces

## comparison
equals(x)   > boolean           returns true if text is identical to x
equalsIgnoreCase(x) > boolean   equals, but ignores uppercase
compareto(x) > int              unicode dec value (str1 - str2)
compareToIgnoreCase(x) > int    compareTo, but ignores uppercase

## indexing
charAt(index) > char            returns the char from specified index
indexOf(str) > int              returns the index of substring's first occurrence
lastIndexOf(str) > int          returns the index of substring's last occurrence
contains(str) > bool            true if the string contains arg substring
startsWith(str) > bool          true if the string contains arg prefix
endsWith(str) > bool            true if the string contains arg suffix 

## typecasting
Integer.ParseInt()              int > string
Type.ParseType()                use any type here to cast Type x > String



## substrings and replacements
substring(x, y) > string        returns the substring from indeces [x, y)
replace(old, new)               replace all instances of a character or a substring
replaceAll(r1, r2) > string     regex based replace
replaceFirst(r1, r2) > string   regex based replacefirst

## trim, spaces
trim() > String                 removes spaces from prefix-suffix
strip() > String                removes unicode-spaces (more accurate than trim)
stripLeading() > String         strip prefix-only
stripTrailing() > String        strip suffix-only

## upper-lowercase
both support Locale as args

toUpperCase() > String          change all chars to uppercase
toLowerCase() > String          change all chars to lowercase

# split-concat
split(str regex, int limit) > String[]      split. Limit (list length) is optional
concat(str) > str                           concatenate, adding arg to end
String.join("spr", x1, x2) > String         join multiple strings, using the provided separator

# other
repeat(int count) > string      repeat the string x times

codePointAt(int index) > int            returns unicode dec at index
codePointBefore(int index) > int        returns unicode before index
codePoints() > IntStream                returns a stream of unicode





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

- other
scanner.nextLine();             // clears the contents of a scanner

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
break, continue work as in python


## for loop
// i++ autoincrement, i-- autodecrement

// start, condition, end can be left out,
for(start; condition; end;){
    ...
}

// infinite loop 
for(;;){
    ...
}


// for x in range(10)
for(int i = 0; i<10; i++){
    ...
}

// iterate over elements
int[] nums = {1, 2, 3, 4}
for (int n : nums) {
    ...
}

// multi-variable for-loop
for(int i = 0, int j = 10; i < j; i++, j--) {
    ...
}


## while loop
while(condition){
    ...
}


## do-while loop. runs at least once.
do{
    ...
}while(condition);

## infinite loops
for( ; ; ) {…}
while (true) {…}
do {…} while (true);


# Ternary if-else (tingimusavaldis)
(condition) ? (if-true) : (else);
!! has to return a value, doesnt work with void !!

example:
int x = condition ? 1 : 2;





# try-catch block
try{
    ...
} catch (exceptionType - optional) {
    ...
} finally-optional {
    ...
}

assert(condition)   // exception kui pole condition

# Switches (lülitidirektiiv)
// when variable == value1 and no breaks, it will do all 3

switch(variable) {
    case value1: cmd1; break;
    case value2: cmd2; break;
    default: cmd3; // optional
}

## Enchanced switches

String day = "Saturday";
boolean weekday;

switch(day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> weekday = true;
    case "Saturday", "Sunday" -> weekday = false;
    default -> weekday = false;
}
if (weekday) {
    System.out.println("It's a weekday");
}
else{
    System.out.println("It's weekend");
}





# methods

[access modifier] [static/instance] [return type] [method name](params) {
    ...
    return value;
}

## overloaded methods
methods that share the same name, but different parameters
signature = name + parameters
- format: methodname(type, type)

## access modifiers

modifier        seen by:
private         same class
protected       same class and -package
public          same class and -package, subclass
(**empty)       same class and -package, subclass and -package
                "empty" is called package private

## static/instance
static                  belongs to the class, shared between all objects
instance/non-static     belongs to an object, all get their separate values
                        created when not using the static keyword







# variable scope

## local/parameter variables
Local variables are set inside functions, loops or blocks. They exist only inside said structures

void f1(int y) {
    int x = 5;             ## local variable
    system.out.println(y); ## parameter variable
    System.out.println(x);
}
x = 5   // error, because it's not defined

## instance variables
Instance variables are defined inside classes. Every instance of an object has a different set of the same instance variables.
Created outside methods, non-static

class Person {
    String name; // instance variable
}
Person p1 = new Person();
Person p2 = new Person();
p1.name = "Alice";
p2.name = "Bob";

## class (static) variables
defined inside classes by using "static"
shared between all objects, access through class.

class Counter {
    static int total = 0;
}
Counter.total = 5;

## block scope
all items defined inside a block can't be seen outside the block.
To bypass this, create variables before starting a block

if (true) {
    int x = 10; // block scope
}
x = 11 // error, because x doesnt exist





# collections (list, array, set, ...)

## list - ordered, non-unique
types of lists:
- ArrayList         dynamic, indexing, random add/remove, fixed length after creation
- LinkedList        doubly linked list, indexing, random add/remove
- Vector            synchronized ArrayList

Main methods:
add(), get(), set(), remove(),
size(), contains(), indexOf(), sort(), forEach()

## set - might be ordered, unique
- HashSet           unordered, fast lookup
- LinkesHashSet     preserves insertion order
- TreeSet           sorted elements

Main methods: add(), remove(), contains(), size(), iterator(), clear()

## Queue / Deque - FIFO or LIFO
- LinkesList        queue and deque
- PriorityQueue     priority queue
- ArrayDeque        double-ended queue. fast.

Main methods: add(), offer(), poll(), peek(), remove(), addFirst(), addLast()

## Map - dictionaries, key-value pairs
Does not extend collection, but is part of the framework.

- HashMap           fast lookup, unordered
- LinkedHashMap     preserves insertion order
- TreeMap           sorted by keys

Main methods:
put(), get(), remove()
containsKey(), containsValue()
keySet(), values(), entrySet()

## Collection hierarchy

Collection Framework
│
├─ Collection (interface)
│   ├─ List        → ArrayList, LinkedList, Vector
│   └─ Set         → HashSet, LinkedHashSet, TreeSet
│   └─ Queue / Deque → LinkedList, PriorityQueue, ArrayDeque
│
└─ Map (interface, not a Collection)
    ├─ HashMap
    ├─ LinkedHashMap
    └─ TreeMap




# arrays, 2D-arrays
import java.util.Arrays;


## creating an array
// arrays will be at fixed length after creation
String[] fruits = {"apple", "orange", "banana"};    // fixed length of 3
String[] foods = new String[3];                     // create an empty array of len(3)

## array methods
int numfruits = fruits.length;      // get the length of an array
Arrays.sort(fruits);                // sort in natural order (depending on type)
Arrays.fill(fruits, "pineapple");   // fill (replace) all elements with the arg

System.out.println(fruits[0]);      // indexing 
fruits[0] = "apple"                 // set a value to an index

## looping through an array
// for i in len(fruits)
for(int i = 0; i < fruits.length; i++) {
    System.out.println(fruits[i]);
}

// enhanced for loop (for x in fruit)
for(String fruit : fruits){
    System.out.println(fruit);
}

## searching an array
int[] numbers = {1, 3, 6, 2, 5, 7};
int target = 2;
boolean isfound = false;

for(int i = 0; i < numbers.length; i++) {
    if(target == numbers[i]){
        System.out.println("item found at index: " + i);
        // for strings, you need to use equals method
        isfound = true;
        break;
    }
}
if(!isFound){
    System.out.println("item not found");
}

## 2D-arrays
// creating an array
String[] fruits = {"apple", "orange"};
String[] vegetables = {"potato", "onion"};
String[][] groceries = {fruits, vegetables, {"butter", "pork"}};

// creating an empty array
boolean[][] booleans = new boolean[2][3];

// indexing
String potato = groceries[1][0];
boolean[2] = new boolean[]{true, false, true};





# ArrayLists

## creating Arraylists
import java.util.ArrayList;

ArrayList<Type> list = new ArrayList<>(); // replace Type with a value


## methods
- all methods have a prefix of "listname."

add(item)               append to a list
add(i, item)            add to an index
set(i, item)            replace a value on an index
get(i)                  get a value from an index
remove(i)               remove from an index
remove(item)            remove the first corresponding value

size() > int            get the length of a list
isEmpty() > bool        check if the list is empty
contains(item) > bool   check if the list contains an item
clear()                 remove all elements from a list




# Varargs - allow a method to accept a varying num of arguments
// java will pack the arguments into an array (ellipsis)

// only 1 vararg per method, it has to be the last argument'
// for multiple varargs, use arrays as args instead

static int add(int... numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    return sum;
}