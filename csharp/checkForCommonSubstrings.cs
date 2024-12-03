using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;
/**
 * This checks if two strings share a common substring.
 */
class Solution {
    // Complete the twoStrings function below.
    static string twoStrings(string s1, string s2) {
        bool []alphaBoolVector = new bool[26]; //Vector for storing character occurances
        for(int i = 0; i < 26; i++)
            alphaBoolVector[i]=false; //set each element as false
        for(int i = 0; i < s1.Length; i++){
            alphaBoolVector[s1[i]-'a'] = true; //If s1 contains a character, set that character's corresponding element in ABV to "true"
        }
        for(int i = 0; i < s2.Length; i++){
            if(alphaBoolVector[s2[i]-'a']){
                return "YES";
            }
        }
        return "NO";
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int q = Convert.ToInt32(Console.ReadLine());

        for (int qItr = 0; qItr < q; qItr++) {
            string s1 = Console.ReadLine();

            string s2 = Console.ReadLine();

            string result = twoStrings(s1, s2);

            textWriter.WriteLine(result);
        }

        textWriter.Flush();
        textWriter.Close();
    }
}
