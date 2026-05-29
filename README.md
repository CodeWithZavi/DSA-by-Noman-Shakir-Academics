<!-- Author: NOMAN SHAKIR -->

# DSA Academic

Academic Data Structures and Algorithms implementations, practice questions, and mini projects. The repository is primarily Java, with selected Python, C, and C++ examples.

## Table of Contents

- Overview
- Repository Structure
- Requirements
- Quick Start
- Algorithms and Data Structures
- LeetCode Practice
- Projects
- Configuration and Secrets
- Documentation
- Contributing
- License

## Overview

This repo is a consolidated academic workspace that includes:

- Core data structures and classic algorithms
- Search and sorting implementations
- LeetCode-style practice problems
- A JavaFX recommendation engine project
- A Python secure document management demo
- Timetable management samples in multiple languages

## Repository Structure

```text
DSA-Academic/
  DataStructureAndAlgorithms/
    Algorithms/
      AVLTree/
      BinarySearchTree/
      CirculatLinkedList/
      doublyendedcircularlinkedlist/
      doublylinkedlist/
      Hashset/
      HufmanCoding/
      InorderTransversals/
      SearchingAlgorithms/
      SinglyLinkedList/
      SortingAlgortithms/
      encryptionalgorithms/
    Leetcode/
      PraticeQuestions/
    projects/
      AdaptiveRecommendationEngine/
    README.md
  timetablemangementsystem/
  CONTEXT.md
  project-graph.md
  README.md
```

## Requirements

- Java JDK 21+ for Java examples and the JavaFX project
- Maven 3.8+ for the Adaptive Recommendation Engine
- Python 3.10+ for the encryption demo
- MongoDB Community Server for the encryption demo

## Quick Start

Run a single Java file:

```bash
cd DataStructureAndAlgorithms/Algorithms/AVLTree
javac AVLTree.java
java AVLTree
```

Run the Adaptive Recommendation Engine:

```bash
cd DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine
mvn javafx:run
```

Run the encryption demo:

```bash
cd DataStructureAndAlgorithms/Algorithms/encryptionalgorithms
python main.py
```

## Algorithms and Data Structures

Core structures and examples live under [DataStructureAndAlgorithms/Algorithms](DataStructureAndAlgorithms/Algorithms). Highlights include:

- Linked lists: [SinglyLinkedList](DataStructureAndAlgorithms/Algorithms/SinglyLinkedList), [doublylinkedlist](DataStructureAndAlgorithms/Algorithms/doublylinkedlist), [CirculatLinkedList](DataStructureAndAlgorithms/Algorithms/CirculatLinkedList), [doublyendedcircularlinkedlist](DataStructureAndAlgorithms/Algorithms/doublyendedcircularlinkedlist)
- Trees and traversals: [AVLTree](DataStructureAndAlgorithms/Algorithms/AVLTree), [BinarySearchTree](DataStructureAndAlgorithms/Algorithms/BinarySearchTree), [InorderTransversals](DataStructureAndAlgorithms/Algorithms/InorderTransversals)
- Searching algorithms: [SearchingAlgorithms](DataStructureAndAlgorithms/Algorithms/SearchingAlgorithms)
  - BFS, DFS, binary search, recursive binary search
  - A*, IDA*, greedy search, hill climbing
  - Interpolation, jump, and ternary search
- Sorting algorithms: [SortingAlgortithms](DataStructureAndAlgorithms/Algorithms/SortingAlgortithms)
  - Bubble, selection, insertion, quick, and brick sort
- Hashing and Huffman coding: [Hashset](DataStructureAndAlgorithms/Algorithms/Hashset), [HufmanCoding](DataStructureAndAlgorithms/Algorithms/HufmanCoding)

## LeetCode Practice

LeetCode-style practice questions are in [DataStructureAndAlgorithms/Leetcode/PraticeQuestions](DataStructureAndAlgorithms/Leetcode/PraticeQuestions).

## Projects

### Adaptive Recommendation Engine

A JavaFX application that combines collaborative filtering and graph-based recommendations with custom data structures.

- Location: [DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine](DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine)
- Stack: Java 21, JavaFX, Maven
- Features: collaborative filtering, graph traversal, custom priority queue, interactive UI

Run:

```bash
cd DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine
mvn javafx:run
```

Additional docs:

- [README_COMPLETE.md](DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine/README_COMPLETE.md)
- [QUICKSTART.md](DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine/QUICKSTART.md)
- [TROUBLESHOOTING.md](DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine/TROUBLESHOOTING.md)

### Secure Document Management System (Encryption Demo)

A Python demo that implements hybrid encryption (AES-256 + RSA-2048) with SHA-256 integrity checks and role-based access.

- Location: [DataStructureAndAlgorithms/Algorithms/encryptionalgorithms](DataStructureAndAlgorithms/Algorithms/encryptionalgorithms)
- Tech: Python, MongoDB, RSA/AES cryptography

Setup:

```bash
cd DataStructureAndAlgorithms/Algorithms/encryptionalgorithms
pip install -r storage/requirements.txt
python main.py
```

Details: [DataStructureAndAlgorithms/Algorithms/encryptionalgorithms/storage/README.md](DataStructureAndAlgorithms/Algorithms/encryptionalgorithms/storage/README.md)

### Timetable Management System

Small academic examples in Java, C, and C++-style code.

- Location: [timetablemangementsystem](timetablemangementsystem)
- Files: Timetablemangementsystem.java, TimetableMangementSystem(C).c, TimetableMangementSystemC#.cpp

Example compile commands:

```bash
# Java
javac Timetablemangementsystem.java
java Timetablemangementsystem

# C
gcc TimetableMangementSystem(C).c -o timetable
./timetable

# C++
g++ TimetableMangementSystemC#.cpp -o timetablepp
./timetablepp
```

## Configuration and Secrets

Do not commit real credentials. Configure locally when needed:

```text
SPOTIFY_CLIENT_ID
SPOTIFY_CLIENT_SECRET
AUDD_API_TOKEN
ACRCLOUD_ACCESS_KEY
ACRCLOUD_SECRET_KEY
```

Spotify setup for the recommendation engine is configured in [DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine/src/main/java/com/dsa/core/SpotifyConfig.java](DataStructureAndAlgorithms/projects/AdaptiveRecommendationEngine/src/main/java/com/dsa/core/SpotifyConfig.java).

## Documentation

- Project context: [CONTEXT.md](CONTEXT.md)
- Architecture map: [project-graph.md](project-graph.md)
- Algorithms index: [DataStructureAndAlgorithms/README.md](DataStructureAndAlgorithms/README.md)

## Contributing

This is an academic repository. Suggestions and improvements are welcome via issues or pull requests.

## License

Add a license file if you want to allow reuse under specific terms.
