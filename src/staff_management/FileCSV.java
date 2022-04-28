package staff_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCSV {
    public static final String PATH = "C:\\Users\\hongh\\IdeaProjects\\staff_management\\src\\data\\staff.csv";

    public List<Staff> readFile(List<Staff> list) throws Exception {
        FileReader fileReader = new FileReader(PATH);
        Scanner sc = new Scanner(fileReader);
        list.clear();
        if (sc.nextLine() != null){
            while (sc.hasNext()){
                String out = sc.nextLine();
                String[] arr = out.split(",");
                Staff staff = new Staff(arr[0],Boolean.parseBoolean(arr[1]),Boolean.parseBoolean(arr[2]),Double.parseDouble(arr[3]));

                list.add(staff);
            }
        } else {
            throw new Exception();
        }

        return list;
    }

    public void writeFile(List<Staff> list) throws IOException {
        FileWriter fileWriter = new FileWriter(PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String inp = "TÊN,LOẠI,STATUS,LƯƠNG\n";
        for (Staff s : list) {
            inp += s.getName() + ","
                    + s.getType() + ","
                    + s.geStatus() + ","
                    + s.getSalary() + "\n";
        }
        bufferedWriter.write(inp);
        bufferedWriter.close();
        fileWriter.close();
    }
}
