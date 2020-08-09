import java.util.Arrays;

public class MyInt {
  private int[] nb = new int[25];

  // constructor
  public MyInt(String integer) {
    int count = integer.length() - 1;
    for (int i = this.nb.length - 1; i >= 0 && count >= 0; i--, count--) {
      this.nb[i] = integer.charAt(count) - '0';
    }
  }

  // copy constructor
  public MyInt(MyInt other) {
    this.nb = other.nb;
  }

  // This method add MyInts
  public MyInt add(MyInt other) {
    int[] sumArray = new int[25];
    int sum = 0, carry = 0;
    for (int i = this.nb.length - 1; i >= 0; i--) {
      sum = this.nb[i] + other.nb[i] + carry;
      sumArray[i] = sum % 10;
      carry = sum / 10;
    }
    return new MyInt(getString(sumArray));
  }

  // This method check if MyInts are equal
  public boolean isEqual(MyInt other) {
    for (int i = 0; i < 25; ++i) {
      if (this.nb[i] != other.nb[i])
        return false;
    }
    return true;
  }

  // This method compare MyInts
  public int compareTo(MyInt other) {
    if (isEqual(other))
      return 0;
    for (int i = 0; i < 25; ++i) {
      if (this.nb[i] > other.nb[i])
        return 1;
      else if (this.nb[i] < other.nb[i])
        return -1;
    }
    return -1;
  }

  public String getString(int[] a) {
    String str = "";
    boolean found = false;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        found = true;
      }
      if (a[i] == 0 && !found)
        continue;
      str += a[i];
    }
    if (str.length() == 0)
      return "0";
    return str;
  }

  public String toString() {
    return getString(this.nb);
  }

  public static void main(String[] args) {
    MyInt MyInt1 = new MyInt("38423");
    MyInt MyInt2 = new MyInt("27");
    System.out.println(MyInt1.isEqual(MyInt2));
    System.out.println(MyInt2.compareTo(MyInt1));
    MyInt myInt3 = new MyInt("3948692348692348693486235");
    MyInt myInt4 = new MyInt("5834938349234856234863423");
    System.out.println(myInt3.compareTo(myInt4));
    System.out.println(MyInt1.add(MyInt2));
    System.out.println(myInt3.add(myInt4));
  }
}
