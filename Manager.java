
package librarymodel;


    public class Manager extends User {
    public Manager(String id, String name) { 
        super(id, name); }
    @Override
    public void performRole() {
        System.out.println(" Managers of Library resource");
        System.out.println("Manager ID:"+id+"\nManager Name:"+name);
    }
}

