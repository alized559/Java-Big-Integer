import java.util.Arrays;

public class MyIntsCollection {
  private MyInt[] myInts;

  // constructor
  public MyIntsCollection(MyInt[] integers) {
    this.myInts = integers;
  }

  // empty constructor
  public MyIntsCollection() {
    this.myInts = new MyInt[1];
  }

  // This method sort the array of MyInts
  public MyInt[] sort(boolean isAsc) {
    MyInt[] sortedMyInts = Arrays.copyOf(this.myInts, this.myInts.length);
    int compareKey = isAsc ? +1 : -1;
    for (int i = 0; i < sortedMyInts.length - 1; i++) {
      for (int j = 1; j < sortedMyInts.length - i; j++) {
        if (sortedMyInts[j - 1].compareTo(sortedMyInts[j]) == compareKey) {
          // swap
          MyInt temp = sortedMyInts[j - 1];
          sortedMyInts[j - 1] = sortedMyInts[j];
          sortedMyInts[j] = temp;
        }
      }
    }
    return sortedMyInts;
  }

  // This method returns the index of MyInt in the array
  public int indexOf(MyInt other) {
    for (int i = 0; i < this.myInts.length; i++) {
      if (this.myInts[i].isEqual(other))
        return i;
    }
    return -1;
  }

  // This method add element to the array
  public void append(MyInt other) {
    if (this.myInts[0] == null) {
      this.myInts[0] = other;
    } else {
      MyInt[] newArray = new MyInt[this.myInts.length + 1];
      for (int i = 0; i < this.myInts.length; i++)
        newArray[i] = this.myInts[i];
      newArray[this.myInts.length] = other;
      this.myInts = newArray;
    }
  }

  // This method sum MyInts
  public MyInt sumAll() {
    MyInt sum = new MyInt("0");
    for (int i = 0; i < this.myInts.length; i++)
      sum = sum.add(this.myInts[i]);
    return sum;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < this.myInts.length; i++)
      str += this.myInts[i].toString() + "\n";
    return str;
  }

  public static void main(String[] args) {
    MyInt[] a = {new MyInt("23"), new MyInt("16"), new MyInt("51")};
    MyIntsCollection collection = new MyIntsCollection(a);
    MyInt[] sortedArray = collection.sort(false);
    System.out.println(Arrays.toString(a));
    System.out.println("sorted array: " + Arrays.toString(sortedArray));
    System.out.println("index of 51: " + collection.indexOf(new MyInt("51")));
    System.out.println("sum = " + collection.sumAll());
  }
}
