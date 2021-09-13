public class Palindrome {
  // Test if text is a palindrome.
  // Ignore upper/lower case, white space, and punctuation.
  //
  public static boolean isPalindrome(String text) {
    text = text.replaceAll("[^a-zA-Z0-9]", " ");//removes all the special characters from the string and puts a space in place of them
    text=text.toLowerCase();
    text = text.replaceAll("\\s+", "");//By passing “\\s+” as regex which matches one or many whitespaces and “” as replacement for those whitespaces you can remove all whitespaces from a String.
    Stack<String> stack= new Stack<String>();
    for (int i = 0; i < text.length(); i++) {
      char c=text.charAt(i);
      String s=Character.toString(c);
      stack.push(s);
    }
    String reverseText="";
    while (!stack.is_empty()) reverseText = reverseText + stack.pop();
    if(text.equals(reverseText))
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    /*
    Hannah	Madam, I’m Adam
    Rats live on no evil star.	Was it a car or a cat I saw?
    */
    System.out.println("hello world -- palindrom :: "+isPalindrome("hello world"));
    System.out.println("Hannah -- palindrom :: "+isPalindrome("Hannah"));
    System.out.println("Madam, I’m Adam --- palindrom :: "+isPalindrome("Madam, I’m Adam"));
    System.out.println("Rats live on no evil star ---- palindrom :: "+isPalindrome("Rats live on no evil star"));
    System.out.println("Was it a car or a cat I saw? ----- palindrom :: "+isPalindrome("Was it a car or a cat I saw?"));


  }
}
