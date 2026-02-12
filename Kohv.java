public class Kohv {
  private String kohvisort;
  private double hind;
 

  public String getKohvisort() {
    return kohvisort;
  }

  public double getHind() {
    return hind;
  }

  public Kohv(String kohvisort, double hind) {
    this.kohvisort = kohvisort;
    this.hind = hind;
  }

  public static void main(String[] args) {
    System.out.println("suusakepi pikkus on " + suusakepiPikkus());
  }
}



/*




overdefining
public A(int x) {
}
public A() {
this(0); // calls A(int)
}


static methods
- belongs to a class, not to an instance
- can be called without creating an object
- can't directly use non-static (instance) variables or methods
- can't use "this" or "super"


arrays of classes can be created


algtüüp vs viittüüp
a = ...
b = a
Kui a ja b on int, siis kopeeritakse väärtust
Kui a ja b on objektid, siis kopeeritakse viiteid e. objekte on endiselt ainult üks.

algtüübid (primitive) - käituvad esimest pidi
viittüüp - käituvad teist viisi. viittüübiga on ka nt string.
string on immutable e. sisu ei muutu kunagi peale loomist. Kui tehakse näiline muudatus, siis tegelikult luuakse uus string.

stringbuilder - can be used to change a string without creating too many new strings. stringbuilder will return itself until finished
*/



/*
Kas üledefineerimisel on järjestus oluline? Kas peaks millegi "enne" defineerima, kui on teada, et üht varianti on rohkem vaja?
Youtube vs praksi materjalid nädal 1
eng-est translate
*/