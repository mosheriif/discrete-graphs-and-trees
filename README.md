# Graphs and Trees

This repository contains the solution for **Lab 4: Graphs and Trees**, assigned for the (CSE214) Discrete Structures course. The assignment consists of three main tasks related to graphs and trees. Each task involves creating Java programs that utilize specific algorithms and data structures to solve distinct problems.

## Assignment Overview

### 1. **Airline Network Shortest-Path Finder**
   - Develop a tool to find the most efficient route between two airports in an airline network.
   - Model the network as a graph (nodes as airports and edges as flights).
   - Implement Dijkstra's algorithm to find the shortest path between a source and destination.
   - Handle errors for invalid source or destination inputs.

### 2. **Class Schedule Optimisation**
   - Create a program to generate optimized class schedules for a school.
   - Represent classes as nodes in a graph with edges indicating conflicts (classes that cannot overlap).
   - Apply a graph coloring algorithm to assign non-overlapping time slots.
   - Display the timetable with color-coded class timings.

### 3. **Binary Tree Traversal**
   - Implement recursive or iterative methods for Preorder, Inorder, and Postorder traversals of a binary tree.
   - Provide user input for binary tree node values and display traversal results.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/mosheriif/discrete-graphs-and-trees.git
   ```

2. Compile the Java files:
   ```bash
   javac src/*.java
   ```
## Assumptions

- For the class scheduling optimisation problem, the user can only input conflicts in existing classes (e.g. if the classes are A, B, C and D, and the user can only enter classes from these four only).
- There are only ten available colours to choose from.
- The conflicts can only be written in the form `<Class 1>-<Class 2>`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
