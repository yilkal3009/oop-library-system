
package librarymodel;


// 5. Borrow Class - ግንኙነቱን ለመመዝገብ
public class BorrowRecord {
    public String bName;
    public String uName;
    public String date;

    public BorrowRecord(String bName, String uName) {
        this.bName = bName;
        this.uName = uName;
        this.date = new java.util.Date().toString();
    }
}