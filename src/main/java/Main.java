import javax.swing.*;
import java.io.File;

/**
 * Created by jjzzz on 9/28/2016.
 */
public class Main {
    public static void main(String[] args) {
//        args=new String[3];
//        args[0]="img";
//        args[1]="png";
//        args[2]="1";
        if(args.length!=3){
            JOptionPane.showMessageDialog(null,"3 arguments needed","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        String argFolderName=args[0];
        String argFormat=args[1];
        String argKeepOrigName=args[2];

        System.out.println(System.getProperty("user.dir"));
        File folder=new File(argFolderName);
        File[] files=folder.listFiles();
        int counter=0;
        for (File file : files) {
            counter++;
            String nName;
            if(argKeepOrigName.equals("1")) {

                nName=argFolderName+"/"+file.getName().substring(0,file.getName().indexOf("."))+"."+argFormat;
            }
            else
                nName=argFolderName+"/"+counter+"."+argFormat;
            file.renameTo(new File(nName));
        }
    }
}
