package com.daejol.presentation.data

enum class MatchQuestionType(val char: Char) {
    Extroversion('E'),
    Introversion('I'),
    Curious('C'),
    Stable('S'),
    Affectionate('A'),
    Detached('D'),
    Relaxed('R'),
    Lively('L')
}

data class MatchData(
    val question: String,
    val answerList: List<AnswerData>
)

data class AnswerData(
    val answer: String,
    val answerType: MatchQuestionType
)

class MatchResult {
    companion object {
        private val currentResult = mutableMapOf(
            MatchQuestionType.Extroversion to 0,
            MatchQuestionType.Introversion to 0,
            MatchQuestionType.Curious to 0,
            MatchQuestionType.Stable to 0,
            MatchQuestionType.Affectionate to 0,
            MatchQuestionType.Detached to 0,
            MatchQuestionType.Relaxed to 0,
            MatchQuestionType.Lively to 0
        )

        private val matchPairList = listOf(
            Pair(MatchQuestionType.Extroversion, MatchQuestionType.Introversion),
            Pair(MatchQuestionType.Curious, MatchQuestionType.Stable),
            Pair(MatchQuestionType.Affectionate, MatchQuestionType.Detached),
            Pair(MatchQuestionType.Relaxed, MatchQuestionType.Lively)
        )

        private val matchQuestionData = listOf(
            MatchData(
                question = "고양이 카페에 간 당신",
                answerList = listOf(
                    AnswerData("먼저 적극적으로 다가간다.", MatchQuestionType.Extroversion),
                    AnswerData("다가올 때까지 기다린다.", MatchQuestionType.Introversion)
                )
            ),
            MatchData(
                question = "친구들이 우리 동네에 놀러 왔을 때",
                answerList = listOf(
                    AnswerData("우리 고양이가 제일 귀여워. 집으로 초대해서 고양이를 자랑한다.", MatchQuestionType.Extroversion),
                    AnswerData("집은 고양이와 나만의 공간. 우리 동네 핫플에서 실컷 놀기.", MatchQuestionType.Introversion),
                )
            ),
            MatchData(
                question = "집을 비워야 할 때 나는",
                answerList = listOf(
                    AnswerData("고양이 호텔에 맡긴다..", MatchQuestionType.Extroversion),
                    AnswerData("우리 고양이와 안면을 튼 지인을 집에 부른다.", MatchQuestionType.Introversion),
                )
            ),
            MatchData(
                question = "동네 마트에 새로운 고양이 간식이 입고됐다. 우리 고양이에게 먹여 볼까?",
                answerList = listOf(
                    AnswerData("새로운 간식을 시도해 본다.", MatchQuestionType.Curious),
                    AnswerData("먹던 걸로 주세요.", MatchQuestionType.Stable),
                )
            ),
            MatchData(
                question = "우리 고양이와 교감하기 위해 나는",
                answerList = listOf(
                    AnswerData("내 말 알겠지? 조잘조잘.", MatchQuestionType.Curious),
                    AnswerData("말 안해도 내 마음 알지?", MatchQuestionType.Stable),
                )
            ),
            MatchData(
                question = "선반 위 소중한 나의 굿즈들을 다 헤집어 놓은 우리 고양이에게",
                answerList = listOf(
                    AnswerData("올려 둔 내가 잘못이지…", MatchQuestionType.Curious),
                    AnswerData("안돼!!! 다시 올려 놔", MatchQuestionType.Stable),
                )
            ),
            MatchData(
                question = "길가다가 처음 마주친 고양이!",
                answerList = listOf(
                    AnswerData("친해지도록 만지고 놀아 준다.", MatchQuestionType.Affectionate),
                    AnswerData("안돼!!! 다시 올려 놔", MatchQuestionType.Detached),
                )
            ),
            MatchData(
                question = "신경쓰이는 길냥이가 있을 때 나는",
                answerList = listOf(
                    AnswerData("가방에 항상 츄르 구비", MatchQuestionType.Affectionate),
                    AnswerData("간식은 만나면 사주지 뭐!", MatchQuestionType.Detached),
                )
            ),
            MatchData(
                question = "열대야에도 꼭 붙어 자려는 우리 고양이",
                answerList = listOf(
                    AnswerData("쪄 죽어도 함께야", MatchQuestionType.Affectionate),
                    AnswerData("우리 조금만 떨어질까?", MatchQuestionType.Detached),
                )
            ),
            MatchData(
                question = "우리 고양이에게 선물하고 싶은 장난감은?",
                answerList = listOf(
                    AnswerData("어항", MatchQuestionType.Relaxed),
                    AnswerData("캣휠", MatchQuestionType.Lively),
                )
            ),
            MatchData(
                question = "집에서 쉬는 날 나와 고양이는",
                answerList = listOf(
                    AnswerData("냥생 존중, 여가시간은 각자 보내기", MatchQuestionType.Relaxed),
                    AnswerData("낚싯대로 휘리릭 놀아주기", MatchQuestionType.Lively),
                )
            ),
            MatchData(
                question = "주말에 고양이로 힐링하기로 한 당신",
                answerList = listOf(
                    AnswerData("남의 집 고양이 영상보기", MatchQuestionType.Relaxed),
                    AnswerData("나만의 고양이 스팟으로 출근!", MatchQuestionType.Lively),
                )
            ),
        )

        fun init() {
            currentResult.keys.forEach { key ->
                currentResult[key] = 0
            }
        }

        fun getQuestions(): List<MatchData> {
            return matchQuestionData
        }

        fun add(answer: AnswerData) {
            currentResult[answer.answerType]?.plus(1)
        }

        fun calculateResult(): String {
            var result = ""
            matchPairList.forEach { p ->
                result += if (currentResult[p.first]!! > currentResult[p.second]!!) {
                    p.first.char
                } else {
                    p.second.char
                }
            }

            return result
        }
    }
}