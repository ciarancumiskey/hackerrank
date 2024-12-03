//FIXME Kotlin not configured
//import java.io.*
//import java.math.*
//import java.security.*
//import java.text.*
//import java.util.*
//import java.util.concurrent.*
//import java.util.function.*
//import java.util.regex.*
//import java.util.stream.*
//import kotlin.collections.*
//import kotlin.comparisons.*
//import kotlin.io.*
//import kotlin.jvm.*
//import kotlin.jvm.functions.*
//import kotlin.jvm.internal.*
//import kotlin.ranges.*
//import kotlin.sequences.*
//import kotlin.text.*
//
///**
//* Calculates the numbers of apples and oranges which land on Sam's house.
//* @param houseStart: the starting point of Sam's house
//* @param houseEnd: the end point of Sam's house
//* @param appleTreePos: the position of Sam's apple tree
//* @param orangeTreePos: the position of Sam's orange tree
//* @param apples: the positions of the fallen apples relative to the apple tree
//* @param oranges: the positions of the fallen oranges relative to the orange tree
//*/
//fun countApplesAndOranges(houseStart: Int, houseEnd: Int, appleTreePos: Int, orangeTreePos: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
//    var houseApples = 0; //apples which landed on Sam's house
//    var houseOranges = 0; //oranges which landed on Sam's house
//    for (applePos in apples) {
//        if (houseStart <= applePos + appleTreePos && applePos + appleTreePos <= houseEnd)
//            houseApples++
//    }
//    println(houseApples)
//    for (orangePos in oranges) {
//        if(houseStart <= orangePos + orangeTreePos && orangePos + orangeTreePos <= houseEnd)
//            houseOranges++
//    }
//    println(houseOranges)
//}
//
//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val st = scan.nextLine().split(" ") //start and end points of Sam's house
//
//    val s = st[0].trim().toInt()
//
//    val t = st[1].trim().toInt()
//
//    val ab = scan.nextLine().split(" ") //positions of the apple and orange trees
//
//    val a = ab[0].trim().toInt()
//
//    val b = ab[1].trim().toInt()
//
//    val mn = scan.nextLine().split(" ") //the numbers of apples and oranges
//
//    val appleCount = mn[0].trim().toInt()
//
//    val orangeCount = mn[1].trim().toInt()
//
//    //The distances of each apple from their tree
//    val apples = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//    //The distances of each orange from their tree
//    val oranges = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    countApplesAndOranges(s, t, a, b, apples, oranges)
//}
//
