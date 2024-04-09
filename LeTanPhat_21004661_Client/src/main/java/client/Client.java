/*
 * @ (#) Client.java     1.0   4/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import entity.*;
/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/9/2024
 * @version:  1.0
 */
public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("192.168.1.8", 7878);

            Scanner sc = new Scanner(System.in);
        ){

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            int choice = 0;

            while(true) {

                System.out.println("Enter your choice: \n"
                        + "1. Find all course\n"
                        + "2. Find course by id\n");

                choice  = sc.nextInt();

                out.writeInt(choice);

                switch (choice) {
                    case 1:
                        out.flush();

                        List<Course> courses = (List<Course>) in.readObject();
                        courses.forEach(System.out::println);

                        break;
                        case 2:
                        System.out.println("Enter the id: ");
                        int id = sc.nextInt();

                        out.writeInt(id);
                        out.flush();

                        Course course = (Course) in.readObject();
                        System.out.println(course);

                        break;
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
   
}
