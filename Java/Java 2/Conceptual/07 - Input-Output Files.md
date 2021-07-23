
# Input/Output Files

## File Abstraction

### Binary Files

* Need to know what is going into the file before writing
* All throw I/O exceptions

|Data Type|Number of Bytes|
|-|-|
|byte|1 byte|
|ASCII char|1 byte|
|unicode|2 bytes|
|short|2 bytes|
|int/float|4 bytes|
|double|9 bytes|

* cast a char to int to show table

### `UTF-8`

* ASCII was popular, but now `UTF-8` is very popular
* Popular character encoding
* uses Unicode using one to four 8-bit bytes

### `OutputStream` and `InputStream`

* Abstract Class
* `DataOutputStream` and `BufferedOutputStream`
* `DataInputStream`  and `BufferedInputStream`
* Can only read ***one byte at a time*** with `read()` method
* If primative, then must specify with methods like `readShort()`
* Reads data om way that is independant of type of machine, like Windows or Mac
* `flush()` method - forces all buffered bytes to be written to disk immediately. Data not always written to disk. Maybe need to save quickly
* Data must be `serializable`, `transient`, or `primitive`
    + must read the same data type that is originally written
    + ORder is important as well - sequential
* Throws end of file exception when reaches end of file

### `Buffer`ing

* Reads more than one bytes at a time
* more efficent to write and read in blocks
* common example are storage devices, like harddrives

Reader|Writer|
|-|-|
|Reads in blocks of bytes at a time|stores written data in cache and writes data when complete|

### `ObjectInputStream` and `ObjectOutputStream`

* Reads and write entire objects at a time
* Implements `Serializable` interface
* Use `transient` keyword to prevent data from being written to disk
