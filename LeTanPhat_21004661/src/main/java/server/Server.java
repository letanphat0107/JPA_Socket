/*
 * @ (#) Server.java     1.0   4/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package server;

import dao.impl.CourseImpl;
import entity.Course;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/9/2024
 * @version:  1.0
 */
public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(7878)) {
            System.out.println("Server is listening on port 7878...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                System.out.println("Client IP: " + socket.getInetAddress().getHostName());

                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (Exception ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
    }
}
}
class ClientHandler implements Runnable {
    private Socket client;
    private CourseImpl courseImpl;
    public ClientHandler(Socket socket) {
        super();
        this.client = socket;
        courseImpl = new CourseImpl();
    }
    @Override
    public void run(){
        try{
            DataInputStream in = new DataInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            int choice = 0;

            while(true) {
                choice = in.readInt();
                switch (choice) {
                    case 1:
                        List<Course> courses = courseImpl.findAll();
//					response to client

                        out.writeObject(courses);
                        break;
                    case 2:
                        int id = in.readInt();
                        System.out.println("ID: " + id);
                        Course course = courseImpl.findById(id, Course.class);
                        out.writeObject(course);
                        break;
                }
            }

        }catch (Exception ex){
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

