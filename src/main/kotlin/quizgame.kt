import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.Scanner

fun main() {

    val json : String = """{
  "quiz": {
    "maths": {
      "q1": {
        "question": "5 + 7 = ?",
        "options": [
          "10",
          "11",
          "12",
          "13"
        ],
        "answer": "12"
      },
      "q2": {
        "question": "12 - 8 = ?",
        "options": [
          "1",
          "2",
          "3",
          "4"
        ],
        "answer": "4"
      },
      "q3": {
        "question": "15 * 3 = ?",
        "options": [
          "35",
          "45",
          "50",
          "55"
        ],
        "answer": "45"
      },
      "q4": {
        "question": "20 / 5 = ?",
        "options": [
          "2",
          "3",
          "4",
          "5"
        ],
        "answer": "4"
      },
      "q5": {
        "question": "8 * 4 = ?",
        "options": [
          "24",
          "28",
          "32",
          "36"
        ],
        "answer": "32"
      },
      "q6": {
        "question": "16 / 4 = ?",
        "options": [
          "2",
          "3",
          "4",
          "5"
        ],
        "answer": "4"
      },
      "q7": {
        "question": "9 + 6 = ?",
        "options": [
          "13",
          "14",
          "15",
          "16"
        ],
        "answer": "15"
      },
      "q8": {
        "question": "18 - 7 = ?",
        "options": [
          "9",
          "10",
          "11",
          "12"
        ],
        "answer": "11"
      },
      "q9": {
        "question": "25 * 2 = ?",
        "options": [
          "40",
          "45",
          "50",
          "55"
        ],
        "answer": "50"
      },
      "q10": {
        "question": "24 / 6 = ?",
        "options": [
          "2",
          "3",
          "4",
          "5"
        ],
        "answer": "4"
      }
    }
  }
}"""

    val quizContainer = Json.decodeFromString<QuizContainer>(json)
    val scanner = Scanner(System.`in`)
    var score = 0
    var userAnswerIndex = 0

    //display the data for understanding

//    for (question in quizContainer.quiz.maths){
//
//        println(question.value)
//    }

//container>maths>quiz>questions>options

    quizContainer.quiz.maths.forEach { (key, question) ->
        println(question.question)
        question.options.forEachIndexed { index, option ->
            println("${index + 1}. $option")
        }

        /* Loop for checking if user input wrong option then check and re-enter the option from the user */
        while (true) {
            print("Enter Your answer (1-${question.options.size}): ")
            try {
                userAnswerIndex = scanner.nextInt()
                if (userAnswerIndex < 1 || userAnswerIndex > question.options.size) {
                    println("Please enter a option between 1 and ${question.options.size}.")
                    continue
                }
                break
            } catch (e: Exception) {
                println("Invalid input. Please enter a number.")
                scanner.nextLine()

            }

        }
        if ((question.options[userAnswerIndex - 1]).toInt() == (question.answer).toInt()) {
            score += 10
        }
    }

    println("size of question "+quizContainer.quiz.maths.size)
    
    val totalScore = (score * 100) / (quizContainer.quiz.maths.size * 10)
    println("Your score is: $totalScore out of 100")
}