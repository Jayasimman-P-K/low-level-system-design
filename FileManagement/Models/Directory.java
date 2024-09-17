package FileManagement.Models;

import java.util.List;

public class Directory {
    private String dirName;
    private List<Directory> subDirectories;
    private List<File> files;

    public Directory(String dirName) {
        this.dirName = dirName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public List<File> getFiles() {
        return files;
    }

    public Directory getSubDirectory(String dirName) {
        for (Directory subDirectory : subDirectories) {
            if (subDirectory.getDirName().equals(dirName)) {
                return subDirectory;
            }
        }
        return null;
    }

    public File getFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public void addSubDirectory(Directory subDirectory) {
        subDirectories.add(subDirectory);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeSubDirectory(String dirName) {
        subDirectories.removeIf(subDirectory -> subDirectory.getDirName().equals(dirName));
    }

    public void removeFile(String fileName) {
        files.removeIf(file -> file.getFileName().equals(fileName));
    }
}
