import kotlinx.serialization.Serializable


@Serializable
data class QuizContainer(val quiz: Quiz)

@Serializable
data class Quiz(val maths: Map<String, Question>)

@Serializable
data class Question(
    val question: String,
    val options: List<Int>,
    val answer: String
)