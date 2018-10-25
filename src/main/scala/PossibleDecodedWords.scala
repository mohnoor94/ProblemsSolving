/**
  * *** 'Facebook' interview question ***
  *
  * Given a mapping between characters and numbers as:
  * a : 1, b : 2, c : 3, d : 4, ..., y : 25, z : 26
  * you can encode any string like:
  * - "ab"  ==> "12"
  * - "car" ==> "3119"
  * - "l"   ==> "12"
  * noticing that one character could be encoded into 1 or 2 digits, multiple strings could be encoded to the same code,
  * like "ab" and "l" examples above.
  * <p>
  * The problem: given the encoded word, return the number of possibilities that this word could be decoded to.
  * Examples:
  * - "12" ==> 2 ("ab", "l")
  * - "01" ==> 0 (no word could be encoded to this form)
  * <p>
  * More details: https://youtu.be/qli-JCrSwuk
  */
object PossibleDecodedWords {

  def main(args: Array[String]): Unit = {
    println(numberOfWays("12"))
    println(numberOfWays("01"))
    println(numberOfWays("011"))
    println(numberOfWays("3"))
    println(numberOfWays(""))
    println(numberOfWays("12345"))
    println(numberOfWays("111111"))
  }

  def numberOfWays(data: String): Int = {
    val memo = new Array[Int](data.length + 1)

    def helper(data: String, k: Int, memo: Array[Int]): Int = {
      if (k == 0) return 1
      val i = data.length - k
      if (data(i) == '0') return 0
      if (memo(k) != 0) return memo(k)

      var result = helper(data, k - 1, memo)
      if (k >= 2 && data.substring(i, i + 2) <= "26")
        result += helper(data, k - 2, memo)
      memo(k) = result

      result
    }

    helper(data, data.length, memo)
  }
}
