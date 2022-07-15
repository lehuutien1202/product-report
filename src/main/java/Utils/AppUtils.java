package Utils;

import View.InputOption;
import View.QLSVView;
import View.SearchSt;

import java.util.Scanner;

public class AppUtils {
    static Scanner sc = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(System.in);

    public static String retryString(String field) {
        String result;
        while ((result = sc.nextLine()).isEmpty()) {
            ;
            System.out.printf("%s không được để trống, hãy nhập lại: ", field);
        }
        return result;
    }

    public static boolean isRetryAdmin(InputOption inputOption) {
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Nhấn 'n' để thêm tiếp \t|\t 'b' để quay lại \t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'n' để sửa tiếp \t|\t 'b' để quay lại\t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'n' để xóa tiếp \t|\t 'b' để quay lại\t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'b' để về giao diện chính \t|\t 'r' để quay lại \t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case SEARCH:
                    System.out.println("Nhấn 'b' để về giao diện chính \t|\t 't' để quay lại \t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case INFO:
                    System.out.println("Nhấn 'b' để về giao diện chính \t|\t 'y' để quay lại \t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case ADD_INFO:
                    System.out.println("Nhấn 'n' để thêm tiếp \t|\t 'b' để về giao diện chính \t|\t 'z' để quay lại \t|\t 'e' để thoát chương trình \t|\t 's' để đăng xuất");
                    break;
                case SIGNIN:
                    System.out.println("Nhấn 'n' để nhập lại \t|\t 's' để thoát chương trình");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }
            System.out.print(" Chọn ➤ ");
            String option = sc.nextLine();
            switch (option) {
                case "n":
                    return true;
                case "b":
                    QLSVView adminView = new QLSVView ();
                    adminView.runAdmin ();
                    break;
//                case "r":
//                    AdminView show = new AdminView ();
//                    show.showStudentList ();
//                    break;
                case "t":
                    SearchSt searchSt = new SearchSt();
                    searchSt.searchStudent();
                    break;
//                case "y":
//                    LaunchAdminView infoView = new LaunchAdminView ();
//                    infoView.infoStudentView ();
//                    break;
//                case "z":
//                    ShowStudent student = new ShowStudent ();
//                    student.showAddInfoStudent ();
//                    break;
                case "e":
                    exit ();
                    break;
                case "s":
                    login ();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);


    }
    public static int retryChoose ( int min, int max){
        int option;
        do {
            System.out.print("➯➯ Chọn: ");
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng, hãy chọn lại: ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai, hãy nhập lại: ");
            }
        } while (true);
        return option;

    }
    public static boolean exit() {
        System.out.println ( "* * *BẠN MUỐN ĐÓNG CHƯƠNG TRÌNH* * *" );
        System.out.println ( "*                                  *" );
        System.out.println ( "*          ▫ 1. Xác nhận           *" );
        System.out.println ( "*          ▪ 2. Hủy bỏ             *" );
        System.out.println ( "*                                  *" );
        System.out.println ( "* * * * * *- - - - - - - -* * * * * *" );
        int choose = AppUtils.retryChoose ( 1, 2 );
        switch (choose) {
            case 1:
                System.out.println ( "\tCODEGYM HUẾ, tạm biệt và hẹn gặp lại!" );
                System.exit ( 1 );
                break;
            case 2:
                return true;
        }
        return false;
    }
    public static Long retryParseLong() {
        long result;
        do {
            System.out.print ( "➱➱ " );
            try {
                result = Long.parseLong ( sc.nextLine () );
                return result;
            } catch (Exception ex) {
                System.out.print ( "Nhập sai! vui lòng nhập lại " );
            }
        } while (true);
    }
    public static boolean login() {
        QLSVView qlsvView = new QLSVView();
        System.out.println ( "* * *BẠN MUỐN XÓA ĐĂNG XUẤT* * *" );
        System.out.println ( "*                              *" );
        System.out.println ( "*        ▫ 1. Xác nhận         *" );
        System.out.println ( "*        ▪ 2. Hủy bỏ           *" );
        System.out.println ( "*                              *" );
        System.out.println ( "* * * * * ------------ * * * * *" );
        int choose = AppUtils.retryChoose ( 1, 2 );
        switch (choose) {
            case 1:
                qlsvView.run();
                break;
            case 2:
                return true;
        }
        return false;
    }
}