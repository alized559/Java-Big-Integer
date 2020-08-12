import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SumAndSort {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("Ints.txt");
    sumInts(file);
  }

  // This method sum all the MyInts in the collection
  public static void sumInts(File file) throws FileNotFoundException {
    Scanner readFromFile = new Scanner(file);
    MyIntsCollection collection = new MyIntsCollection();
    while (readFromFile.hasNextLine()) {
      String line = readFromFile.nextLine();
      Scanner readFromLine = new Scanner(line);
      while (readFromLine.hasNext()) {
        MyInt num = new MyInt(readFromLine.next());
        collection.append(num);
      }
      System.out.println(collection.sumAll());
      collection = new MyIntsCollection();
    }
  }
}
