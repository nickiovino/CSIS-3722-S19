package javaapplication1;

public class JavaApplication1
{
    public static void main(String[] args)
    {
        UserInfo[] users = new UserInfo[2];

        users[0] = new UserInfo();
        users[0].id = 0;
        users[0].name = "Nick";
        users[0].age = -12;

        users[1] = new UserInfo();
        users[1].id = 1;
        users[1].name = "Mark";
        users[1].age = -24678;
        
        for( int i = 0; i < 2; i++ )
        {
            System.out.println(users[i].name);
        }
        
        for (UserInfo user : users)
        {
            user.address = "422 Wick Ave";
            if( user.age > -100 )
            {
                System.out.println("Name: " + user.name);
                System.out.println("Age: " + user.age);
                System.out.println("Address: " + user.address);
            }
            else
            {
                System.out.println("User is really young.");
            }
            
            switch(user.name)
            {
                case "Nick":
                    System.out.println("Hello!");
                    break;
                case "Mark":
                    System.out.println("World!");
                    break;
            }
        }
    }
}
