package FileManagement.Services;

import java.util.Stack;

import FileManagement.Models.Directory;
import FileManagement.Models.File;

public class FileManagementService {
    private Directory root;
    private Stack<Directory> deletedDirectories;
    private Stack<File> deletedFiles;

    public FileManagementService() {
        this.root = new Directory("root");
        this.deletedDirectories = new Stack<>();
        this.deletedFiles = new Stack<>();
    }

    private Directory getDirectoryByPath(String path) {
        String[] names = path.split("/");
        Directory current = root;

        for (String name : names) {
            if (name.isEmpty()) continue;
            current = current.getSubDirectory(name);
            if (current == null) return null;
        }

        return current;
    }

    // 1. Create a new directory and file in all Levels.
    public void createDirectory(String path, String dirName) {
        Directory parentDir = getDirectoryByPath(path);
        if (parentDir != null) {
            parentDir.addSubDirectory(new Directory(dirName));
        } else {
            System.out.println("Parent directory does not exist!!");
        }
    }

    public void createFile(String path, String fileName, String content) {
        Directory parentDir = getDirectoryByPath(path);
        if (parentDir != null) {
            parentDir.addFile(new File(fileName, content));
        } else {
            System.out.println("Parent directory does not exist!!");
        }
    }

    // 2. List all directories and files.
    public void list(String path) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            System.out.println("Directory: " + directory.getDirName());
            System.out.println("|-- SubDirectories: ");
            for (Directory subDir: directory.getSubDirectories()) {
                System.out.println("    |-- " + subDir.getDirName());
            }
            System.out.println("|-- Files: ");
            for (File file : directory.getFiles()) {
                System.out.println("    |-- " + file.getFileName());
            }
        } else {
            System.out.println("Directory does not exits!!");
        }
    }

    // 3. Update file content.
    public void updateFileContent(String path, String fileName, String newContent) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            File file = directory.getFile(fileName);
            if (file != null) {
                file.setContent(newContent);
            } else {
                System.out.println("File does not exist!!");
            }
        } else {
            System.out.println("Directory does not exist!!");
        }
    }

    // 4. Update directory and file names.
    public void updateDirName(String path, String oldName, String newName) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            Directory subDir = directory.getSubDirectory(oldName);
            if (subDir != null) {
                subDir.setDirName(newName);
            } else {
                System.out.println("SubDirectory does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    public void updateFileName(String path, String oldName, String newName) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            File file = directory.getFile(oldName);
            if (file != null) {
                file.setFileName(newName);
            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    } 

    // 5. Delete directory and file.
    public void deleteDirectory(String path, String dirName) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            Directory subDir = directory.getSubDirectory(dirName);
            if (subDir != null) {
                directory.removeSubDirectory(dirName);
                deletedDirectories.push(subDir);
            } else {
                System.out.println("SubDirectory does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    public void deleteFile(String path, String fileName) {
        Directory directory = getDirectoryByPath(path);
        if (directory != null) {
            File file = directory.getFile(fileName);
            if (file != null) {
                directory.removeFile(fileName);
                deletedFiles.push(file);
            } else {
                System.out.println("File doest not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    } 

    // 6. Restore deleted directories and files.
    public void restoreDeletedDirectory() {
        if (!deletedDirectories.isEmpty()) {
            Directory restoredDir = deletedDirectories.pop();
            createDirectory("/", restoredDir.getDirName());
            // Assuming restoredDir is to be added to root for simplicity
            root.addSubDirectory(restoredDir);
        } else {
            System.out.println("No directories to restore.");
        }
    }

    public void restoreDeletedFile() {
        if (!deletedFiles.isEmpty()) {
            File restoredFile = deletedFiles.pop();
            // Assuming restoredFile is to be added to root for simplicity
            root.addFile(restoredFile);
        } else {
            System.out.println("No files to restore.");
        }
    }

}
