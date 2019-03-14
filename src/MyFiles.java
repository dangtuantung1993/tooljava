import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.io.FileUtils;
 
public class MyFiles {
    public static void main(String[] args) throws IOException {
        File fileOrDir = new File("C:\\Users\\TDG\\Downloads");
        MyFiles myFiles = new MyFiles();
        myFiles.traverseDepthFiles(fileOrDir);
    }
     
    public void traverseDepthFiles(final File fileOrDir) throws IOException {
        // check xem fileOrDir la file hay foder
        if (fileOrDir.isDirectory()) {
            // in ten folder ra man hinh
            System.out.println(fileOrDir.getAbsolutePath());
             
            final File[] children = fileOrDir.listFiles();
            if (children == null) {
                return;
            }
            // sắp xếp file theo thứ tự tăng dần
            Arrays.sort(children, new Comparator<File>() {
                public int compare(final File o1, final File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for (final File each : children) {
                // gọi lại hàm traverseDepthFiles()
                traverseDepthFiles(each);
            }
        } else {
            // in ten file ra man hinh
//            System.out.println(fileOrDir.getAbsolutePath());
            File name = new File("name.txt");
            FileUtils.writeStringToFile(name, fileOrDir.getName() + "\n", "UTF-8",true);
        }
    }
}
