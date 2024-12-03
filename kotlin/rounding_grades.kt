import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
    Takes in an array of students' grades, and then rounds them up if they're both close
    enough to a multiple of 5 and more than the failing grade.
    @param grades: The original grades to be rounded up
    @return: The rounded-up grades
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    return grades.map {
        if (it < 38 || it % 5 < 3) it //Either the student failed or their grade doesn't merit rounding up, so leave it alone
        else it + (5 - it % 5) //Round up the student's grade
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}

