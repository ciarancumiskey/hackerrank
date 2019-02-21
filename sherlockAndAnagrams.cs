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

class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(string s) {
        int anagramCount = 0;
        for(int i = 0; i < s.Length; i++){
            for(int j = i+1; j < s.Length; j++){
                
            }
        }
        return anagramCount;
    }
    static bool checkIfAnagrams(string s1, string s2){
        if(s1.Length != s2.Length){
            return false; //Two strings can't be anagrams if they're of different lengths
        }
        int[] charCount = new int[256]; //one element for every ASCII character
        for(int i = 0; i < s1.Length; i++){
            charCount[[s1[i]]]++;
            charCount[[s2[i]]]--;
        }
        for(int i = 0; i < 256; i++){
            if charCount[i] != 0 {
                return false; //A non-zero number at charCount[i] means that one char appears more in one string than the other
            }
        }
        return true;
    }
    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int numStrings = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < numStrings; i++) {
            string s = Console.ReadLine();

            int result = sherlockAndAnagrams(s);

            textWriter.WriteLine(result);
        }

        textWriter.Flush();
        textWriter.Close();
    }
}
