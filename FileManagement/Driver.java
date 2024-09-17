package FileManagement;

import java.util.Scanner;

import FileManagement.Services.FileManagementService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManagementService fileManagementService = new FileManagementService();

        boolean loop = true;
        while (loop) {
            System.out.print("\n1. Create Dir\n2. Create File\n3. List\n4. Update File Content\n5. Update dir name\n6. Update file name\n7. Delete dir\n8. Delete File\n9. Restore dir\n10. Restore file\n11. Exit\n");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Enter dir path: ");
                    String path = scanner.next();
                    System.out.print("Enter dir name: ");
                    String dirName = scanner.next();
                    fileManagementService.createDirectory(path, dirName);
                    break;
                }
                case 2: {
                    System.out.print("Enter file path: ");
                    String path = scanner.next();
                    System.out.print("Enter file name: ");
                    String fileName = scanner.next();
                    System.out.print("Enter the content: ");
                    String content = scanner.next();
                    fileManagementService.createFile(path, fileName, content);
                    break;
                }
                case 3: {
                    System.out.print("Enter path to list: ");
                    String path = scanner.next();
                    fileManagementService.list(path);
                    break;
                }
                case 4: {
                    System.out.print("Enter file path: ");
                    String path = scanner.next();
                    System.out.print("Enter file name: ");
                    String fileName = scanner.next();
                    System.out.print("Enter the content: ");
                    String updatedContent = scanner.next();
                    fileManagementService.updateFileContent(path, fileName, updatedContent);
                    break;
                }
                case 5: {
                    System.out.print("Enter dir path: ");
                    String path = scanner.next();
                    System.out.print("Enter old dir name: ");
                    String oldDirName = scanner.next();
                    System.out.print("Enter new dir name: ");
                    String newDirName = scanner.next();
                    fileManagementService.updateDirName(path, oldDirName, newDirName);
                    break;
                }
                case 6: {
                    System.out.print("Enter file path: ");
                    String path = scanner.next();
                    System.out.print("Enter old file name: ");
                    String oldFileName = scanner.next();
                    System.out.print("Enter new file name: ");
                    String newFileName = scanner.next();
                    fileManagementService.updateFileName(path, oldFileName, newFileName);
                    break;
                }
                case 7: {
                    System.out.print("Enter dir path: ");
                    String path = scanner.next();
                    System.out.print("Enter dir name to delete: ");
                    String deleteDirName = scanner.next();
                    fileManagementService.deleteDirectory(path, deleteDirName);
                    break;
                }
                case 8: {
                    System.out.print("Enter file path: ");
                    String path = scanner.next();
                    System.out.print("Enter file name to delete: ");
                    String deleteFileName = scanner.next();
                    fileManagementService.deleteFile(path, deleteFileName);
                    break;
                }
                case 9: {
                    fileManagementService.restoreDeletedDirectory();
                    break;
                }
                case 10: {
                    fileManagementService.restoreDeletedFile();
                    break;
                }
                case 11: {
                    loop = false;
                    break;
                }

                default : {
                    System.out.println("Not an option. Choose a correct option.");
                }
            }
        }

        scanner.close();
    }
}
