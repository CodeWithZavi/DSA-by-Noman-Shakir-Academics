# Huffman Coding Compression Tool

**Author:** Noman Shakir

## Overview

A comprehensive implementation of the Huffman Coding algorithm in Java with an intuitive graphical user interface (GUI). This application demonstrates lossless data compression by converting text into binary codes based on character frequency, effectively reducing file sizes while maintaining data integrity.

## Table of Contents

- [Features](#features)
- [Algorithm Explanation](#algorithm-explanation)
- [Technical Details](#technical-details)
- [Project Structure](#project-structure)
- [How It Works](#how-it-works)
- [Usage](#usage)
- [Installation](#installation)
- [Requirements](#requirements)
- [Sample Output](#sample-output)
- [Author](#author)

## Features

### Core Functionality
- **Text Compression**: Efficiently compresses text data using Huffman coding algorithm
- **Binary Encoding**: Converts characters to variable-length binary codes
- **Frequency Analysis**: Analyzes character frequencies to build optimal encoding tree
- **Space Calculation**: Displays original size, compressed size, and percentage saved

### GUI Features
- **Modern Interface**: Clean, user-friendly design with tabbed navigation
- **File Upload**: Support for loading text files (.txt format)
- **Real-time Display**: Shows original binary data and compressed binary data
- **Visual Feedback**: Color-coded buttons with hover effects
- **Statistics Panel**: Displays compression statistics and space savings
- **Clear Function**: Easy reset of all fields

## Algorithm Explanation

### What is Huffman Coding?

Huffman Coding is a greedy algorithm used for lossless data compression. It assigns variable-length codes to characters based on their frequency of occurrence:
- **Frequent characters** get shorter codes
- **Rare characters** get longer codes

This results in an overall reduction in the total number of bits needed to represent the text.

### Steps of the Algorithm

1. **Frequency Analysis**: Count the occurrence of each character in the input text
2. **Priority Queue**: Create leaf nodes for each character and add to a min-heap (priority queue)
3. **Tree Construction**:
   - Extract two nodes with minimum frequency
   - Create a new internal node with these two as children
   - Add the new node back to the priority queue
   - Repeat until only one node remains (the root)
4. **Code Assignment**: Traverse the tree to assign binary codes
   - Left child: append '0'
   - Right child: append '1'
5. **Encoding**: Replace each character with its binary code
6. **Compression**: Convert binary string to actual binary format

### Example

For the text `"AAAA"`:
- Character 'A' appears 4 times
- Frequency: A=4
- Since only one unique character, assign code '0'
- Compressed: `0000` (4 bits instead of 32 bits for standard ASCII)

## Technical Details

### Data Structures Used

1. **Priority Queue (Min-Heap)**
   - Stores nodes ordered by frequency
   - Ensures efficient retrieval of minimum frequency nodes
   - Time complexity: O(log n) for insertion and deletion

2. **Binary Tree**
   - Represents the Huffman encoding structure
   - Leaf nodes contain characters
   - Internal nodes store frequency sums

3. **Node Class**
   - Properties: character, frequency, left child, right child, binary code
   - Implements Comparable interface for priority queue ordering

### Classes Overview

#### 1. `Node.java`
```java
- character: char          // The character stored in the node
- frequency: int          // Frequency of the character
- left: Node             // Left child (represents '0')
- right: Node            // Right child (represents '1')
- binCode: String        // Binary code for this character
```

**Key Methods:**
- `buildCode(String code)`: Recursively builds binary codes for all nodes
- `getCode(char c)`: Retrieves the binary code for a specific character
- `compareTo(Node other)`: Compares nodes based on frequency

#### 2. `HuffmanCoding.java`
**Key Methods:**
- `readFile(String filePath)`: Reads text from a file
- `writeBinaryFile(String filePath, String data)`: Writes binary data to file
- `compress(String text)`: Main compression algorithm

**HuffmanResult Class:**
- Stores original text, binary representations, and size metrics

#### 3. `HuffmanCodingGUI.java`
**UI Components:**
- Input text area for manual text entry
- Original binary data display
- Compressed binary data display
- Size statistics labels
- Upload, Compress, and Clear buttons

**Features:**
- Modern color scheme (blue, green, red)
- Hover effects on buttons
- Tabbed interface for organized display
- File chooser for text file uploads
- Error handling with message dialogs

## Project Structure

```
HuffmanCoding/
├── src/
│   └── huffmancoding/
│       ├── Node.java                 # Node class for Huffman tree
│       ├── HuffmanCoding.java       # Core compression logic
│       └── HuffmanCodingGUI.java    # GUI application
├── build/
│   └── classes/                     # Compiled class files
├── nbproject/                       # NetBeans project files
├── output.txt                       # Sample compressed output
├── put.txt                          # Sample input file
├── putcompressed.txt                # Sample compressed file
├── build.xml                        # Ant build file
├── manifest.mf                      # Manifest file
└── README.md                        # This file
```

## How It Works

### Compression Process

1. **Input**: User enters text or uploads a text file
2. **Analysis**: Program counts character frequencies
3. **Tree Building**: Constructs Huffman tree using priority queue
4. **Code Generation**: Assigns binary codes to each character
5. **Encoding**: Replaces characters with their binary codes
6. **Output**: Displays original vs compressed binary data with statistics

### Edge Cases Handled

- **Single unique character**: Assigns code '0' to avoid empty tree
- **Empty input**: Shows warning message
- **File read errors**: Displays error dialog with details
- **Binary file writing**: Handles byte conversion properly

## Usage

### Running the Application

1. **Launch the GUI**:
   ```
   Run HuffmanCodingGUI.java main method
   ```

2. **Enter Text**:
   - Type directly into the "Input Text" tab
   - Or click "Upload File" to load a text file

3. **Compress**:
   - Click "Compress Text" button
   - View results in "Original Data" and "Compressed Data" tabs

4. **View Statistics**:
   - Original size in bits
   - Compressed size in bits
   - Space saved (bits and percentage)

### Example Workflow

```
Input: "HELLO WORLD"
↓
Frequency Analysis: H=1, E=1, L=3, O=2, W=1, R=1, D=1, Space=1
↓
Build Huffman Tree
↓
Generate Codes: L="00", O="01", etc.
↓
Encode: "HELLO WORLD" → binary string
↓
Result: Show compression ratio
```

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (optional, but project is configured for it)
- Windows/Linux/Mac operating system

### Setup Steps

1. **Clone or Download** the project
2. **Open in IDE**:
   - NetBeans: Open project directly
   - Eclipse/IntelliJ: Import as existing project
3. **Build Project**:
   ```
   ant build (if using Ant)
   ```
   Or use your IDE's build function
4. **Run Application**:
   ```
   java huffmancoding.HuffmanCodingGUI
   ```

### Manual Compilation (Command Line)

```bash
# Navigate to src directory
cd HuffmanCoding/src

# Compile all Java files
javac huffmancoding/*.java

# Run the GUI application
java huffmancoding.HuffmanCodingGUI
```

## Requirements

### System Requirements
- **Java Runtime Environment (JRE)**: Version 8 or higher
- **RAM**: 512 MB minimum (1 GB recommended)
- **Disk Space**: 50 MB for application and temporary files
- **Display**: 1024x768 minimum resolution (1400x900 recommended)

### Dependencies
- Java Swing (included in JDK)
- Java AWT (included in JDK)
- Java I/O (included in JDK)
- Java Util (included in JDK)

*No external libraries required!*

## Sample Output

### Console Output
```
Original Text: "HELLO"
Original Binary: 01001000 01000101 01001100 01001100 01001111
Original Size: 40 bits

Compressed Binary: 1001000101010111001000110010001010101110010001
Compressed Size: 46 bits (Example - actual varies by text)

Space Saved: Depends on text pattern and character distribution
```

### GUI Display
- **Input Tab**: Shows entered or uploaded text
- **Original Data Tab**: Displays binary representation using standard ASCII (8 bits/char)
- **Compressed Data Tab**: Shows Huffman-encoded binary with variable-length codes
- **Statistics**: Shows exact bit counts and savings percentage

## Time Complexity

- **Building Frequency Table**: O(n) where n = length of text
- **Building Priority Queue**: O(m log m) where m = unique characters
- **Building Huffman Tree**: O(m log m)
- **Encoding Text**: O(n)
- **Overall**: O(n + m log m)

## Space Complexity

- **Storage**: O(m) for tree nodes and frequency table
- **Output**: O(n) for compressed binary string

## Advantages of Huffman Coding

✓ **Lossless**: No data is lost during compression  
✓ **Optimal**: Produces optimal prefix-free codes  
✓ **Efficient**: Works well for text with repeated characters  
✓ **Universal**: Can compress any type of data  
✓ **Simple**: Easy to understand and implement  

## Limitations

- **Fixed Codes**: Codes are fixed after tree is built (no adaptive coding)
- **Two-Pass Algorithm**: Requires full text scan before compression
- **Not Ideal for Random Data**: Works best when character frequencies vary
- **Overhead**: Small files may not compress well due to tree storage overhead

## Future Enhancements

- [ ] Add decompression functionality
- [ ] Support for binary file compression
- [ ] Adaptive Huffman coding implementation
- [ ] Compression ratio graphs and statistics
- [ ] Export Huffman tree visualization
- [ ] Batch file processing
- [ ] Command-line interface option

## License

This project is created for educational purposes as part of Data Structures and Algorithms coursework.

## Author

**Noman Shakir**

- Project: Huffman Coding Implementation
- Course: Data Structures and Algorithms (DSA)
- Year: 2026

---

### Acknowledgments

This implementation demonstrates core concepts in:
- Greedy Algorithms
- Binary Trees
- Priority Queues
- Data Compression
- GUI Design with Java Swing

### Contact

For questions or suggestions regarding this implementation, please reach out through your course instructor or academic portal.

---

*© 2026 Noman Shakir - All Rights Reserved*
