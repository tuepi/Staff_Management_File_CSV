package staff_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StaffManagement staffManagement = new StaffManagement();
        FileCSV fileCSV = new FileCSV();

        String showMenu = """
                =================MENU================
                1. HIỂN THỊ TẤT CẢ NHÂN VIÊN
                2. THÊM
                3. TÌM KIẾM
                4. IN RA DANH SÁCH NHÂN VIÊN FULLTIME
                5. SỬA
                6. ĐỔI TRẠNG THÁI
                7. TÍNH TỔNG LƯƠNG CÁC NHÂN VIÊN
                0. THOÁT
                """;

        String calMenu = """
                ===========TÍNH TỔNG===========
                1. Lương NV Fulltime
                2. Lương NV Parttime
                0. Thoát
                """;

        String printStaffMenu = """
                ===========HIỂN THỊ===========
                1. Nhân Viên Fulltime
                2. Nhân Viên Parttime
                0. Thoát
                """;

        int choice = -1;
        do {
            System.out.println(showMenu);
            System.out.print("Nhập lựa chọn >>> ");
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        staffManagement.showStaffList();
                        break;
                    case 2:
                        Staff staff = staffManagement.creatStaff();
                        staffManagement.add(staff);
                        System.out.println("Thêm Thành công");
                        break;
                    case 3:
                        System.out.print("Nhập tên nhân viên cần tìm kiếm: ");
                        String name = sc.nextLine();
                        staffManagement.findByName(name);
                        break;
                    case 4:
                        int choicePrint = -1;
                        do {
                            System.out.println(printStaffMenu);
                            System.out.print("Nhập lựa chọn >>> ");
                            choicePrint = Integer.parseInt(sc.nextLine());
                            switch (choicePrint){
                                case 1:
                                    System.out.println("Danh sách Nhân viên Fulltime: ");
                                    staffManagement.printFulltime();
                                    break;
                                case 2:
                                    System.out.println("Danh sách Nhân viên Parttime: ");
                                    staffManagement.printParttime();
                                    break;
                                default:
                                    System.out.println("Nhập lại lựa chọn:");
                            }
                        }while (choicePrint != 1 && choicePrint != 2);
                        break;
                    case 5:
                        System.out.print("Nhập tên nhân viên muốn sửa: ");
                        String nameEdit = sc.nextLine();
                        Staff staffEdit = staffManagement.creatStaff();
                        staffManagement.editByName(nameEdit, staffEdit);
                        break;
                    case 6:
                        System.out.print("Nhập tên nhân viên muốn sửa trạng thái làm việc: ");
                        String nameUpdate = sc.nextLine();
                        staffManagement.updateStaffStatus(nameUpdate);
                        break;
                    case 7:
                        int choiceCal = -1;
                        do {
                            System.out.println(calMenu);
                            System.out.print("Nhập lựa chọn >>> ");
                            choiceCal = Integer.parseInt(sc.nextLine());
                            switch (choiceCal){
                                case 1:
                                    staffManagement.calSalaryFulltime();
                                    break;
                                case 2:
                                    staffManagement.calSalaryParttime();
                                    break;
                                default:
                                    System.out.println("Nhập lại lựa chọn:");
                            }
                        }while (choiceCal != 1 && choiceCal != 2);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Nhập lại lựa chọn 0 > 7 ");
                }
            } catch (Exception e){
                System.out.println("Nhập lại lựa chọn 0 > 7 ");
            }
        } while (choice != 0);
    }
}
