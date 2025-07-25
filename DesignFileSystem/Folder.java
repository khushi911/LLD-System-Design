import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    String name;
    List<FileSystemItem> fileSystemList = new ArrayList<>();

    public Folder(String name){
        this.name=name;
    }

    public void add(FileSystemItem item){
        fileSystemList.add(item);
    }

    @Override
    public int getSize(){
        int total =0;
        for(FileSystemItem item : fileSystemList){
            total+= item.getSize();
        }
        return total;
    }

    @Override
    public void printStructure(){
        System.out.println(" /"+name +"/ ");
        for(FileSystemItem item : fileSystemList){
            item.printStructure();
        } 
    }

    @Override
    public void delete(){
        for (FileSystemItem item : fileSystemList) {
            item.delete();
        }
        System.out.println("Deleting folder: " + name);
    }
}
