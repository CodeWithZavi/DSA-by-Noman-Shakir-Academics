<!-- Author: NOMAN SHAKIR -->

# DSA Academic

A collection of academic Data Structures and Algorithms implementations, practice problems, and small projects written mainly in Java, with additional Python, C, and C++ examples.

## Author

NOMAN SHAKIR

## Repository Contents

```text
DSA-Academic/
  DataStructureAndAlgorithms/
    Algorithms/
      AVLTree/
      BinarySearchTree/
      SearchingAlgorithms/
      SortingAlgortithms/
      encryptionalgorithms/
    Leetcode/
    projects/
      AdaptiveRecommendationEngine/
  timetablemangementsystem/
```

## Topics Covered

- Linked lists: singly, doubly, circular, and doubly-ended circular lists
- Trees: AVL tree, binary search tree, and traversal examples
- Searching: linear, binary, recursive binary, interpolation, jump, ternary, BFS, DFS, A*, IDA*, greedy search, and hill climbing
- Sorting: bubble sort, selection sort, insertion sort, quick sort, and brick sort
- Hashing and Huffman coding examples
- LeetCode-style practice questions
- Timetable management examples in C, Java, and C++-style code
- Adaptive Recommendation Engine project using JavaFX, Maven, Spotify API concepts, and custom DSA structures
- Python encryption demo using local MongoDB

## Requirements

- Java JDK 21 or newer for the Java examples and JavaFX project
- Maven 3.8 or newer for `AdaptiveRecommendationEngine`
- Python 3.10 or newer for Python examples
- Local MongoDB only if running the encryption demo

## Running Examples

Compile and run an individual Java example from its folder:

```bash
javac FileName.java
java ClassName
```

Run the Adaptive Recommendation Engine:

```bash
cd DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine
mvn javafx:run
```

Run the Python encryption demo:

```bash
cd DataStructureAndAlgorithms/Algorithms/encryptionalgorithms
python main.py
```

## Environment Variables

The repository should not contain real credentials. Configure these locally when needed:

```text
SPOTIFY_CLIENT_ID
SPOTIFY_CLIENT_SECRET
AUDD_API_TOKEN
ACRCLOUD_ACCESS_KEY
ACRCLOUD_SECRET_KEY
```

`AUDD_API_TOKEN`, `ACRCLOUD_ACCESS_KEY`, and `ACRCLOUD_SECRET_KEY` are only needed for the audio recognition workflows.

## GitHub Push Notes

- Do not commit local build outputs such as `target/`, `out/`, `.class` files, or local Maven distributions.
- Do not commit generated audio samples, encrypted local storage files, or API credentials.
- Rotate any credential that was previously written into code or documentation before making the repository public.

## Documentation

- `CONTEXT.md` contains the living project context.
- `project-graph.md` contains the architecture map and ingestible JSON graph.

## License

Add a license file before publishing if you want others to reuse this code under specific terms.
