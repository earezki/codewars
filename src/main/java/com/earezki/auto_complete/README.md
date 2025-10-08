### **Problem Statement**

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array `sentences` and an integer array `times` both of length `n` where `sentences[i]` is a previously typed sentence and `times[i]` is the corresponding number of times it was typed.
For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the rules:

1.  The hot degree for a sentence is defined as the number of times it was typed.
2.  The returned top 3 sentences should be sorted by hot degree (descending). If two sentences have the same hot degree, you should sort them by lexicographical order (ascending).
3.  If less than 3 valid sentences exist, return as many as you can.
4.  If no valid sentences exist, return an empty list.

The `AutocompleteSystem` class should be implemented:

* `AutocompleteSystem(String[] sentences, int[] times)` Initializes the object with the historical data.
* `List<String> input(char c)` Takes a character as input and returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If the character is '#', it means the sentence is finished, and you need to return an empty list.

---

### **Example 1**

**Input:**
`["AutocompleteSystem", "input", "input", "input", "input"]`
`[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]`

**Output:**
`[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]`

**Explanation:**
`AutocompleteSystem` `acs` = `new AutocompleteSystem`(`["i love you", "island", "iroman", "i love leetcode"]`, `[5, 3, 2, 2]`);

* `acs.input('i')`: Returns `["i love you", "island", "i love leetcode"]`. There are 4 sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has smaller ASCII value than 'r', "i love leetcode" comes before "ironman". Also, "i love you" has the highest hot degree, so it comes first.
* `acs.input(' ')`: Returns `["i love you", "i love leetcode"]`. There are 2 sentences that have prefix "i ".
* `acs.input('a')`: Returns `[]`. There are no sentences that have prefix "i a".
* `acs.input('#')`: Returns `[]`. The user finished the input, the sentence "i a" should be saved as a historical sentence with hot degree 1. Or if the sentence "i a" already exists, its hot degree should be incremented.

---

### **Constraints**

* `n == sentences.length`
* `n == times.length`
* `1 <= n <= 100`
* `1 <= sentences[i].length <= 100`
* `1 <= times[i] <= 50`
* `c` is a lowercase English letter, a space ' ', or a special character '#'.
* Each sentence ends with '#'.
* The input will be a series of characters until a '#' is encountered.
* At most `500` calls will be made to `input`.
