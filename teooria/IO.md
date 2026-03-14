# I/O class
I/O class is used for:
- reading, writing files
- communicating over network sockets
- fintering data
- compress and decompress data
- writing objects to streams
- much more

## data
## character sets
## readers, writers






# File class !! Replaced by Path + Files
The file class is used to read various information from the OS file system:
- file paths
- metadata ()
- permissions (readable, writeable, ...)
- other



## file object
The file object represents a file path, which doesn't necessarily have to exist in the OS file system.
The file object is immutable (path can't be changed)

File constructor:

file f = new File("dir1/file.txt")                  // str fullpath
file f = new File("dir1", "file.txt")               // str parent, str child
file f = new File(new File("dir1"), "file.txt")     // File parent, str child

Instance fields:

File.separator          // file path separator (string). Windows: "\", Linux: "/"
File.separatorchar      // file separator but char
File.pathseparator      // used for PATH variable. Windows: ";", Linux: ":"



## file methods
\\ file type and existence
Exists() > boolean          Check if the file exists in the OS file system
isFile() > boolean          true if its a regular file
isDirectory() > boolean     true if its a directory


\\ permissions
isHidden() > boolean        true if the file is hidden

canRead() > boolean         |
canWrite() > boolean        |   check R, W, X permissions
canExecute() > boolean      |

setReadable(boolean) > boolean      |
setWritable(boolean) > boolean      |   Set R, W, X permissions
setExecutable(boolean) > boolean    |   return: 
setReadOnly() > boolean             |


\\ file metadata
length() > long             returns the file length in bytes
lastModified() > long       timestamp in ms

getName() > String          returns file name without path
getParent() > String        returns parent path
getParentFile() > File      returns parent path's File object

getPath() > String          |
getAbsolutePath() > String  |   get various paths as Str or File.
getAbsoluteFile() > File    |   
getCanonicalPath() > String |   Canonical - absolute path with standard formatting (removes .., symlinks)
getCanonicalFile() > File   |


\\ creating-deleting files
createNewFile() > boolean       creates an empty file if it doesnt exist (linux touch)
mkdir() > boolean               creates a directory
mkdirs() > boolean              creates a directory with missing parent dirs
createTempFile(...)             create a temp file

delete() > boolean              deletes a file
deleteOnExit() > void           delete a file when the program is finished
renameTo(File dest) > boolean   renames a file or moves it to new location (linux move)


\\ reading dir contents
list() > String[]               returns a list of the dir contents
list(FilenameFilter filter)     list() with a filter
listFiles() > File[]            list() that returns file arr instead. can use with filter


\\ File system info
listRoots() > File[]            returns all root dirs (ex: C:\)

getFreeSpace() > long           returns free space of the partition
getTotalSpace() > long          returns total space of the partition
getUsableSpace > long           returns user-available free space





# Path class (java.nio.file.Path)
The Path object represents a file path, which doesn't necessarily have to exist in the OS file system.

Similar to java.io.File, but with less functionality on its own.
To be used with java.nio.file.Files, which will result in more functionality than File.
- Path - strictly path creation and manipulation.
- Files - integration with actual file system, ability to read files


## Path creation
import java.nio.file.Path

Path path = Path.of("dir1/file.txt")                str fullpath
Path path = Path.of("dir1", "file.txt")             str parent, str child


## Path methods
\\ path structure
isAbsolute() > boolean                  true if path is absolute
getRoot() > Path                        return filesystem root ("/", "C:\")

getFileName() > Path                    return last path element (file or dir name)
getParent() > Path                      return parent dir Path

getNameCount() > int                    return the number of elements in the path
getName(int index) > Path               return Path element by index
subpath(int start, int end) > Path      return subpath between indeces


\\ Path comparison
startsWith(Path other) > boolean        true if Path has the given prefix. Can use String as arg.
endsWith(Path other) > boolean          true if Path has the given suffix. Can use String as arg.

equals(Object other) > boolean          true if two path objects represent the same path
compareTo(Path other) > int             lexicographic path comparison
hashCode() > int                        hash for collections

\\ Path manipulation
normalize() > Path                      remove redundant "." and ".." elements
toAbsolutePath() > Path                 convert to absolute path
relativize(Path other) > Path           compute relative path between two paths

resolve(Path other) > Path              append to current path. Can use String as arg.
resolveSibling(Path other) > Path       replace last path element. Can use String as arg.

toUri() > URI                           convert to file URI
toFile() > File                         convert to java.io.File
toString() > String                     convert to String





# Files class (java.nio.file.Files)
Newer and extended version of File class
- Doesn't have filepath functionality

## files methods

\\ file existence & type
exists(Path path) > boolean                     check if the file exists

isRegularFile(Path path) > boolean              true if path is a regular file
isDirectory(Path path) > boolean                true if path is a directory

isReadable(Path path) > boolean                 true if path is readable
isWritable(Path path) > boolean                 true if path is writable
isExecutable(Path path) > boolean               true if path is executable

isSymbolicLink(Path path) > boolean             true if path is a symbolic link


\\ file metadata
size(Path path) > long                          return file size in bytes

getLastModifiedTime(Path path) > FileTime       last modification timestamp
getCreationTime(Path path) > FileTime           file creation timestamp
getOwner(Path path) > UserPrincipal             file owner
probeContentType(Path path) > String            detect MIME type of file


\\ file operations
copy(Path source, Path target) > Path           copy file or dir.           optional args: CopyOption... options
move(Path source, Path target) > Path           move or rename file/dir.    optional args: CopyOption... options

delete(Path path) > void                        delete file/dir
deleteIfExists(Path path) > boolean             delete if exists, return true if deleted

createFile(Path path) > Path                    create new empty file
createDirectory(Path path) > Path               create a directory


\\ reading & writing
readAllBytes(Path path) > byte[]                read file content as byte array
readAllLines(Path path) > List<String>          read file content as lines
readString(Path path) > String                  read file content as string

write(Path path, byte[] bytes) > Path           write bytes to file
writeString(Path path, CharSequence csq) > Path write as string

newBufferedReader(Path path) > BufferedReader   open reader for text
newBufferedWriter(Path path) > BufferedWriter   open writer for text
newByteChannel(Path path) > SeekableByteChannel open byte channel
newInputStream(Path path) > InputStream         open inputstream
newOutputStream(Path path) > OutputStream       open outputstream





# Input/output streams
A stream is an "ordered sequence of bytes of indeterminate length".
- The data travels as a stream of bytes instead of words, rows or other.
- There are classes for more complex data types (int, char, etc), but they all use the stream as a base. 

1. InputStream
   - ByteArrayInputStream   Reads data from a byte array in memory.
   - FileInputStream        Reads bytes from a file.
   - BufferedInputStream    Adds buffering to another InputStream for efficiency.
   - DataInputStream        Allows reading Java primitive data types from an InputStream.
   - ObjectInputStream      Reads Java objects previously written with ObjectOutputStream.
   - PipedInputStream       Reads data from a connected PipedOutputStream.
   - SequenceInputStream    Reads data sequentially from multiple InputStreams.

2. OutputStream
   - ByteArrayOutputStream  Writes data to a byte array in memory.
   - FileOutputStream       Writes bytes to a file.
   - BufferedOutputStream   Adds buffering to another OutputStream for efficiency.
   - DataOutputStream       Allows writing Java primitive data types to an OutputStream.
   - ObjectOutputStream     Writes Java objects for later reading with ObjectInputStream.
   - PipedOutputStream      Writes data to a connected PipedInputStream.



## File input streams

// reading an entire file by byte

import java.io.FileInputStream;
import java.io.IOException;

try(FileInputStream fis = new FileInputStream("input.txt")){
    int data;
    while((data = fis.read()) != -1) {
        System.out.print((char)data);
    }
}
catch(IOException e) {
    e.printStackTrace();
}






# I/O exceptions
IOException                 General input/output exception.
FileNotFoundException       File does not exist or cannot be opened.
EOFException                End of file reached unexpectedly during input.

InterruptedIOException      I/O operation interrupted.
UTFDataFormatException      Malformed UTF-8 data in DataInputStream.
CharConversionException     Character conversion error during reading/writing.

ObjectStreamException       Base class for exceptions related to object serialization.
- InvalidClassException     Incompatible class during deserialization.
- StreamCorruptedException  Corrupted object stream.
- NotSerializableException  Object not serializable.

SyncFailedException         Synchronization to underlying device failed (from FileDescriptor sync). 





# Writing files
some popular options:
- FileWriter        good for small-medium text files
- BufferdWriter     better performance for large amounts of text
- PrintWriter       best for structured data, like reports or logs
- FileOutputStream  best for binary files (images, audio, ...)

important exceptions (all need import java.io.exceptionname):
IOException
FileNotFoundException

## FileWriter
import java.io.FileWriter

FileWriter writer = new FileWriter(String path)
writer.write(String text)

Use multi-line String for longer text """multiline"""





# Reading files
some popular options:
- BufferedReader + FileReader   Best for reading text files line-by-line
- FileInputStream               Best for binary files (images, audio, ...)
- RandomAccessFile              Best for read/write specific portions of a large file

## BufferedReader + FileReader
BufferedReader can't read a file by itself. It makes the FileReader more efficient

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


String path = "C::\\dir1\\file.txt";

// try-with-resources: automatically closes the reader
try(BufferedReader reader = new BufferedReader(new FileReader(path))){
    
    // read line-by-line. If readline() is in the loop itself, it will print null on the last rep.
    String line;
    while((line = reader.readLine()) != null){
        System.out.println(line);
    }
}
catch(IOException e){
    e.printStackTrace();
}

## bufferedreader methods
read()              read one character as unicode (int). File end: -1
readLine()          read one line and return a string, or null at the end
skip(long n)        skip n characters, return how many characters were actually skipped
close()             close the stream, free resources (automatic when using try-with-resources)

read(char[] cbuf)                       fill cbuf until the array is full or end of file. Return the count of read chars.
read(char[] cbuf, int start, int len)   read characters [start:start+len] to cbuf

mark(int readaheadlimit)    mark a position to return to
reset()                     return to the last marked position





# Scanner class
import java.util.Scanner;

Scanner is a class from java.util, which can be used to read input from:
- keyboard
- files
- string
- input stream
- other

Scanner divides the input to tokens. Default division: spaces, tabs, newline

## using a scanner
Scanner sc = new Scanner(source)
...
Scanner.close()

## constructors
Scanner(InputStream source)
Scanner(File source)
Scanner(Path source)
Scanner(String source)
Scanner(Readable source)
Scanner(ReadableByteChannel source)

## scanner methods
// reading tokens
next() > String                 read next token, separated by the delimiter (default: whitespace)
nextLine() > String             read next line, separated by "\n" character
next<Type> > type               read next token and return it as the specified type.
                                can use numerical types
next<Type>(int radix) > type    read next numerical value in the specified number system (2, 10, 16, ...)


// boolean values
hasNext()                       checks if the next token exists
hasNextLine()                   checks if the next line exists
hasNext<Type>()                 checks if the next token can be read as Type
hasNext(Pattern pattern)        checks if the next token matches a Pattern


// regex, patterns
next(Pattern pattern) > String          read next token with a matching pattern
findInLine(String pattern) > String     find a pattern in next line
findWithinHorizon(Str pattern, int n)   find a pattern within next n chars
skip(String pattern) > Scanner          skips next input with a matching pattern
match() > MatchResult                   return last regex match value


// delimiters
useDelimiter(String pattern) > Scanner  Sets a new token delimiter
useDelimiter(Pattern pattern) > Scanner Sets a new token delimiter
delimiter() > Pattern                   Returns current delimiter


// Locale, number systems
useLocale(Locale locale) > Scanner      Sets a locale to read numbers
                                        (manages how numbers are written: 1,1 or 1.1)
locale() > Locale                       returns current locale

useRadix(int radix) > Scanner           set default number system (2, 10, 16, ...)
radix() > int                           return current number system


// scanner object management
close()                                 close the scanner and free resources
reset()                                 reset the scanner to its initial settings
ioException() > IOException             return an exception if it has occurred


