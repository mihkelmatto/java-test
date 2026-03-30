int len;
while(len = ...){ // rewrites len on every cycle

}

# reading/writing files
// chaining streams. When clogins bufferedresder, it will free all memory
new BufferedReader(
    new InputStreamReader(
        new FileInputStream(filename, encoding)



// try-with-resources - using a try block for all input
try-with-resources is a shorter version for this:
- try: creating a new input stream
- catch: IOException
- finally: closing/cleanup
(google exact syntax)

// Closeable/autocloseable

Autocloseable
- close()
- can throw an exception
- can be used in try-with-resources

Closeable
- extends autocloseable
- close() throws IOException
- typical for I&O classes (fileinputstream, bufferedreader)


// writeutf()
...




// 



# Problems with threads
race condition
    when two threads interact with the same variable, it can have unexpected results
    ex. when two threads try to add +n at the same time, some of the increment could get lost
    1. t1 and t2 take the old x, both add 1 and return x+1. If both programs started at the same time, one of the increments will get lost.

    solutions:
        - Synchronize
        - locks
        - atomic operations (faster than first two)
        - immutable objects
        - use threadsafe data structures

deadlock