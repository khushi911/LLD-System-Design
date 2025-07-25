public class Main {
    public static void main(String[] args){
        FileSystemItem file1 = new File("readme.txt", 5);
        FileSystemItem file2 = new File("photo.jpg", 1500);
        FileSystemItem file3 = new File("data.csv", 300);
        
        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file3);

        Folder pictures = new Folder("Pictures");
        pictures.add(file2);

        Folder home = new Folder("Home");
        home.add(documents);
        home.add(pictures);

        System.out.println("---- File Structure ----");
        home.printStructure();

        System.out.println("\nTotal Size: " + home.getSize() + " KB");

        System.out.println("\n---- Deleting All ----");
        home.delete();
    }
}
