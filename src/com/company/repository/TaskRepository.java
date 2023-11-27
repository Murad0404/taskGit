package com.company.repository;

import com.company.dto.Task;
import com.company.enums.TaskStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TaskRepository {

    public boolean deleteTask(int id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "jdbs_user", "123456");
            Statement statement = con.createStatement();
            String rs = "DELETE FROM task WHERE id = "+id;
            int effectedRows = statement.executeUpdate(rs);
            con.close();
            return effectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Task> updateTask(Task task, int id) {
        List<Task> dtoList = new LinkedList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "jdbs_user", "123456");
            Statement statement = con.createStatement();
            String rs = "update task set title= '%s',content = '%s' WHERE id = "+id;
            rs = String.format(rs, task.getTitle(), task.getContent());
            int effectedRows = statement.executeUpdate(rs);
                dtoList.add(task);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    public List<Task> getAllTask() {
        List<Task> dtoList = new LinkedList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "jdbs_user", "123456");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select id,title,content,status,created_date,finished_date from task");

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setContent(rs.getString("content"));
                task.setStatus(TaskStatus.valueOf(rs.getString("status")));
                // task.setCreatedDate(LocalDateTime.parse(rs.getString("created_date")));

                java.sql.Timestamp timestamp = rs.getTimestamp("created_date");
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                task.setCreatedDate(localDateTime);

               /* java.sql.Timestamp timestamp2 = rs.getTimestamp("finished_date");
                LocalDateTime localDateTime2 = timestamp2.toLocalDateTime();
                task.setFinishedDate(localDateTime2);*/
               // task.setFinishedDate(LocalDateTime.parse(rs.getString("finished_date")));
                dtoList.add(task);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoList;
    }


    public void createTask(Task dto) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "jdbs_user", "123456");
            Statement statement = con.createStatement();
            String sql = "insert into task(title,content,status,created_date) values('%s','%s','"+dto.getStatus().toString()+"','"+dto.getCreatedDate() + "')";
            sql = String.format(sql, dto.getTitle(), dto.getContent());
            int effectedRows = statement.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
