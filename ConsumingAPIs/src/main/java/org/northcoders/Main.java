package org.northcoders;

import org.northcoders.dao.FakeBooksDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FakeBooksDAO fakeBooksDAO = new FakeBooksDAO();

        fakeBooksDAO.getThing().data().forEach(System.out::println);


    }
}