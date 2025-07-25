public class File implements FileSystemItem {
    private final String name;
    private final int size;

    public File(String name, int size){
        this.name = name;
        this.size= size;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void printStructure(){
        System.out.println("- "+ name +"("+ size + "KB)");
    }

    @Override
    public void delete(){
        System.out.println("Deleting file: "+name);
    }
}
