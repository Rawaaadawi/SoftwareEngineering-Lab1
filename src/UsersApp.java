import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
public class UsersApp {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<User> users=new ArrayList<User>();

        //now we will read the file, if the username is valis, we will add it, else, exception:
        File file=new File("users.txt");
        Scanner reader=new Scanner(file);

        while(reader.hasNextLine()){
            String line=reader.nextLine();
            String[] parts = line.split("\\s+"); //for example:sara@mail.com    abc123!@, parst[0]=sara@mail.com, parts[1]=abc123!@
            try{
                User user=new User(parts[0],parts[1]);
                users.add(user);
            } catch (IllegalArgumentException e) {
                System.out.println(line);
                System.out.println(e.getMessage());
            }

        }
        reader.close();
        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));

        for(User user:users){
            System.out.println(user.getName()+" "+user.getPassword());
        }

    }


}
