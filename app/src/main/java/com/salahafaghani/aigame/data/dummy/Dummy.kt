package com.salahafaghani.aigame.data.dummy

import com.salahafaghani.aigame.domain.model.GameQuestion

class Dummy {
    companion object {

        val gameQuestions = listOf(
            GameQuestion(
                question = "1 + 1 = ",
                answers = listOf(
                    "0",
                    "1",
                    "2",
                    "3"
                ),
                correctAnswerIndex = 2
            ),
            GameQuestion(
                question = "1 * 1 = ",
                answers = listOf(
                    "0",
                    "1",
                    "2",
                    "3"
                ),
                correctAnswerIndex = 1
            ),
            GameQuestion(
                question = "5 + 5 = ",
                answers = listOf(
                    "5",
                    "10",
                    "15",
                    "20"
                ),
                correctAnswerIndex = 1
            ),
            GameQuestion(
                question = "5 * 5 = ",
                answers = listOf(
                    "10",
                    "15",
                    "20",
                    "25"
                ),
                correctAnswerIndex = 3
            ),
            GameQuestion(
                question = "10 + (4 / 2) = ",
                answers = listOf(
                    "12",
                    "13",
                    "14",
                    "15"
                ),
                correctAnswerIndex = 0
            ),
            GameQuestion(
                question = "(10 - 10) * 10 = ",
                answers = listOf(
                    "0",
                    "10",
                    "100",
                    "1000"
                ),
                correctAnswerIndex = 0
            ),
            GameQuestion(
                question = "25 + 25 * 2 - 1 = ",
                answers = listOf(
                    "24",
                    "49",
                    "74",
                    "99"
                ),
                correctAnswerIndex = 2
            ),
            GameQuestion(
                question = "10 / 2 + 5 = ",
                answers = listOf(
                    "5",
                    "10",
                    "15",
                    "20"
                ),
                correctAnswerIndex = 1
            ),
            GameQuestion(
                question = "100 * 100 = ",
                answers = listOf(
                    "100",
                    "1000",
                    "10000",
                    "100000"
                ),
                correctAnswerIndex = 2
            ),
            GameQuestion(
                question = "1 + 0 * 10000000000 = ",
                answers = listOf(
                    "0",
                    "1",
                    "10",
                    "10000000000"
                ),
                correctAnswerIndex = 1
            )
        )

        val algorithmQuestions = listOf(
            GameQuestion(
                question = "What is the time complexity of the bubble sort algorithm?",
                answers = listOf(
                    "O(n)",
                    "O(n^2)",
                    "O(log n)",
                    "O(n log n)"
                ),
                correctAnswerIndex = 1
            ),
            GameQuestion(
                question = "Which algorithm is used to find the shortest path in a graph with non-negative edge weights?",
                answers = listOf(
                    "Depth First Search",
                    "Dijkstra's Algorithm",
                    "Breadth First Search",
                    "Bellman-Ford Algorithm"
                ),
                correctAnswerIndex = 1
            ),
            GameQuestion(
                question = "What data structure does a Depth First Search algorithm use?",
                answers = listOf(
                    "Queue",
                    "Heap",
                    "Stack",
                    "Hash Table"
                ),
                correctAnswerIndex = 2
            ),
            GameQuestion(
                question = "Which sorting algorithm is known for its stable nature?",
                answers = listOf(
                    "Quick Sort",
                    "Merge Sort",
                    "Heap Sort",
                    "Insertion Sort"
                ),
                correctAnswerIndex = 3
            ),
            GameQuestion(
                question = "In computer science, what does the term 'recursion' refer to?",
                answers = listOf(
                    "The process of dividing a large problem into smaller subproblems",
                    "The process of solving a problem by reducing it to smaller instances of the same problem",
                    "The process of finding a solution to a problem through repeated iterations",
                    "The process of dynamically adjusting the size of a data structure"
                ),
                correctAnswerIndex = 1
            )
        )
    }

    /*

    [
    {
      "question": "What is the time complexity of quicksort algorithm in the best case?",
      "answers": ["O(n log n)", "O(n)", "O(n^2)", "O(log n)"],
      "correct_answer_index": 0
    },
    {
      "question": "Which sorting algorithm has the worst-case time complexity of O(n^2)?",
      "answers": ["Merge Sort", "Insertion Sort", "Heap Sort", "Selection Sort"],
      "correct_answer_index": 1
    },
    {
      "question": "What is the space complexity of heap sort algorithm?",
      "answers": ["O(n log n)", "O(n)", "O(log n)", "O(1)"],
      "correct_answer_index": 3
    },
    {
      "question": "Which data structure is used in Prim's algorithm for finding minimum spanning tree?",
      "answers": ["Heap", "Array", "Stack", "Queue"],
      "correct_answer_index": 0
    },
    {
      "question": "What is the worst-case time complexity of binary search algorithm?",
      "answers": ["O(n)", "O(log n)", "O(n log n)", "O(1)"],
      "correct_answer_index": 1
    }
  ]

     */
}