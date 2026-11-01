package designpattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        System.out.println("Hello from Composite!");

        File file1 = new File("File1.java");
        File file2 = new File("File2.txt");

        File resume = new File("Resume.pdf");
        File project = new File("Project.java");

        Folder documents = new Folder("Documents");
        Folder projects = new Folder("Projects");
        Folder root = new Folder("Root");

        /*
         * root >> file1.java, file2.java documents
         * documents >> resume.pdf, projects
         * projects >> project.java
         * 
         */

        // Add files to Projects
        projects.add(project);

        // Add files and folder to Documents
        documents.add(resume);
        documents.add(projects);

        // Add files and Documents to Root
        root.add(file1);
        root.add(file2);
        root.add(documents);

        // Display entire structure
        root.showDetails();
    }
}

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent {

    private String name;

    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {

        System.out.println("Folder: " + name);

        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}
