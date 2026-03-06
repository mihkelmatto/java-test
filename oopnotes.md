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