package demowebshop.utils;

import demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "kan11@gm.com", "Helloo123!", "Helloo123!"});
        list.add(new Object[]{"Oliver", "Kan", "kan12@gm.com", "Helloo123!", "Helloo123!"});
        list.add(new Object[]{"Oliver", "Kan", "kan13@gm.com", "Helloo123!", "Helloo123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstname(split[0]).setLastname(split[1]).setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();

    }
}
