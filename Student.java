
package librarymodel;



    // 3. Inheritance - ተተኪ ክላሶች
 public class Student extends User {
    public Student(String id, String name) { super(id, name); }
    @Override
    public void performRole() { System.out.println("Role: Student (Can borrow books)"); }
    public void getName(String id, String name){
        
    }
}

