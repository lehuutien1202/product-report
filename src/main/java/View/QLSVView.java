package View;

import Utils.AppUtils;

import java.util.Scanner;

public class QLSVView {
    Scanner scanner = new Scanner(System.in);
    public void run () {


        int choice = -1;
        while (choice != 0) {
            System.out.println(" * * * * * * Log In * * * * * *");
            System.out.println(" *                              *");
            System.out.println(" *                              *");
            System.out.println(" *   1. Admin                   *");
            System.out.println(" *   2. Exit                    *");
            System.out.println(" *                              *");
            System.out.println(" * * * * * * ** * * * * * * * * *");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    StudenView studenView = new StudenView();
                    studenView.loginAdmin();
                    break;
                case 2:
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ ");
            }
        }
    }
    public void runAdmin (){
        StudenView studenView = new StudenView();
        System.out.println(" * * * * * * * * * Admin * * * * * * ** * *");
        System.out.println(" *                                        *");
        System.out.println(" *   1. Hiển Thị Danh Sách SV             *");
        System.out.println(" *   2. Đăng Ký Học Viên Mới              *");
        System.out.println(" *   3. Sửa Thông Tin SV                  *");
        System.out.println(" *   4. Xóa                               *");
        System.out.println(" *   5. Tìm                               *");
        System.out.println(" *   6. Đăng Xuất                         *");
        System.out.println(" *   7. thoát                             *");
        System.out.println(" * * * * * * ** * * * * * * * * * * * * * *");
        System.out.println("Chon chuc nang:");
        int choice = AppUtils.retryChoose(1, 7);
        switch (choice) {
            case 1:
                studenView.showStudentList();
                break;
            case 2:
                studenView.addStudent();
                break;
            case 3:
                studenView.editStudent();
                break;
            case 4:
                studenView.removeStudent();
                break;
            case 5:
                SearchSt searchSt = new SearchSt();
                searchSt.searchStudent();
                break;
            case 6:
                AppUtils.login();
                break;
            case 7:
                AppUtils.exit();
        }
    }
}
