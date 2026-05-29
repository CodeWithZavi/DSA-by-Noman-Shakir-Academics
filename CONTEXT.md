<!-- Author: NOMAN SHAKIR -->

# Project Context

## Tech Stack

- Java 21
- Maven project: `AdaptiveRecommendationEngine` version `1.0-SNAPSHOT`
- JavaFX `21`
- JUnit Jupiter `5.10.0`
- Gson `2.10.1`
- Python scripts for encryption and search examples
- C and C++ academic examples
- Local MongoDB connection for the encryption demo

## Folder Structure

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
        src/main/java/com/dsa/
        src/main/resources/
  timetablemangementsystem/
```

## Environment Variables

- None currently configured as environment variables.

## External Services And Integrations

- Spotify Web API
- ACRCloud/Audd-style audio recognition
- Local MongoDB at `mongodb://localhost:27017/`

## Current Sprint Goal And Status

- Goal: Add clear author comments/metadata for NOMAN SHAKIR across editable DSA Academic files.
- Status: Completed.

## Known Issues / Tech Debt

- Hardcoded third-party credentials exist in Java source and markdown guides. These should be moved to environment variables or a local secrets file and rotated before any public repository push.
- Some folder/file names contain typos, such as `timetablemangementsystem`, `SortingAlgortithms`, and `CirculatLinkedList`.
- Generated and bundled artifacts exist in the repo, including a VSIX, WAV sample, Maven target output, and local Maven distribution files.

## Decision Log

### ADR-001: Use Non-Functional Author Headers

- What: Add author metadata as comments or markdown metadata without changing algorithm behavior.
- Why: The requested change is ownership/commenting, not functional refactoring.
- Alternatives rejected: Deep algorithm rewrites or broad style refactors, because they would add risk and are outside this request.

### ADR-002: Skip Binary And Generated Artifacts

- What: Do not edit `.vsix`, `.wav`, `.enc`, `target/`, or `.local-maven/` files.
- Why: These are binary, generated, or dependency artifacts where comment headers are inappropriate and risky.
- Alternatives rejected: Editing every file indiscriminately, because that can corrupt binaries and generated dependencies.
