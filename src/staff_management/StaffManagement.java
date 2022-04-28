package staff_management;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StaffManagement {
    private List<Staff> list = new ArrayList<>();

    FileCSV fileCSV = new FileCSV();
    Scanner sc = new Scanner(System.in);

    public StaffManagement() throws Exception {
        fileCSV.readFile(list);
    }

    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }

    public Staff creatStaff() {
        System.out.println("Nhập thông tin mới: ");
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        int choice = -1;
        boolean type = false;
        while (choice != 1 && choice != 2){
            System.out.println("Trạng thái: ");
            System.out.println("1. Fulltime");
            System.out.println("2. Parttime");
            System.out.print("Chọn: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        type = true;
                        break;
                    case 2:
                        type = false;
                        break;
                    default:
                        System.out.println("Nhập lại lựa chọn");
                }
            } catch (Exception e){
                System.out.println("Nhập lại lựa chọn");
            }
        }
        int choice1 = -1;
        boolean status = false;
        while (choice1 != 1 && choice1 != 2){
            System.out.println("Trạng thái :");
            System.out.println("1. Đang làm");
            System.out.println("2. Nghỉ làm");
            System.out.print("Chọn: ");
            try {
                choice1 = Integer.parseInt(sc.nextLine());
                switch (choice1){
                    case 1:
                        status = true;
                        break;
                    case 2:
                        status = false;
                        break;
                    default:
                        System.out.println("Nhập lại lựa chọn");
                }
            } catch (Exception e){
                System.out.println("Nhập lại lựa chọn");
            }

        }
        System.out.print("Nhập lương: ");
        double salary = Double.parseDouble(sc.nextLine());

        return new Staff(name, type, status, salary);
    }

    public void add(Staff staff) throws Exception {
        list.add(staff);
        fileCSV.writeFile(list);
        System.out.println("Đã thêm vào danh sách.");
    }

    public void showStaffList() {
        if (list.size() != 0) {
            System.out.println("Danh Sách Nhân Viên: ");
            for (Staff s : list) {
                System.out.println(s);
            }
        } else {
            System.out.println("Danh sách trống!!!");
        }
    }

    public void findByName(String name) {
        int count = 0;
        for (Staff s : list) {
            if (s.getName().contains(name)) {
                count++;
                System.out.println(s);
            }
        }
        if (count == 0) {
            System.out.println("Không có " + name + " trong danh sách!!!");
        }
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void editByName(String name, Staff staff) throws Exception {
        int index = findIndexByName(name);
        if (index != -1) {
            list.set(index, staff);
            setList(list);
            fileCSV.writeFile(list);
            System.out.println("Đã sửa thành công!!!");
        } else {
            System.out.println("Không tồn tại " + name + " trong danh sách!!!");
        }
    }

    public void removeByName(String name) throws Exception {
        int index = findIndexByName(name);
        if (index != -1) {
            list.remove(index);
            setList(list);
            fileCSV.writeFile(list);
            System.out.println("Đã xóa thành công!!!");
        } else {
            System.out.println("Không tồn tại " + name + " trong danh sách!!!");
        }
    }

    public void updateStaffStatus(String name) throws Exception {
        int index = findIndexByName(name);
        if (index != -1){
            boolean change = !list.get(index).isStatus();
            list.get(index).setStatus(change);
            fileCSV.writeFile(list);
            System.out.println("Đã chỉnh sửa trạng thái làm việc.");
        }else {
            System.out.println("Không có " + name + " trong danh sách!!!");
        }
    }

    public void calSalaryFulltime(){
        double sumFulltime = 0;
        for (Staff s : list) {
            if (s.isType() == true){
                sumFulltime += s.getSalary();
            }
        }
        System.out.println("Tổng lương nhân viên Fulltime là: " + sumFulltime);
    }

    public void printFulltime(){
        int count = 0;
        for (Staff s : list) {
            if (s.isType() == true){
                System.out.println(s);
                count++;
            }
        }
        if (count == 0){
            System.out.println("Không có Nhân viên làm Fulltime.");
        }

    }

    public void calSalaryParttime(){
        double sumParttime = 0;
        for (Staff s : list) {
            if (s.isType() == false){
                sumParttime += s.getSalary();
            }
        }
        System.out.println("Tổng lương nhân viên Parttime là: " + sumParttime);
    }

    public void printParttime(){
        int count = 0;
        for (Staff s : list) {
            if (s.isType() == false){
                System.out.println(s);
                count++;
            }
        }
        if (count == 0){
            System.out.println("Không có Nhân viên làm Parttime.");
        }

    }

}
