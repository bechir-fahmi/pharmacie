package core;

import ConnectionDataBase.ConnectionDB;
import models.Pharmacien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PharmacieData {
    private final ConnectionDB db;

    public PharmacieData(ConnectionDB db) {
        this.db = db;
    }
    public List<Pharmacien> GetAllPharmacie() throws SQLException {
        String sql="SELECT * FROM users WHERE role='pharmacie'";
        List<Pharmacien> pharmacienList = new ArrayList<>();
        try (ResultSet result = db.executeQuery(sql)) {
            while (result.next()) {
                Pharmacien pharmacien = new Pharmacien();
                pharmacien.setId(result.getInt("id"));
                pharmacien.setEmail(result.getString("email"));
                pharmacien.setFirstName(result.getString("first_name"));
                pharmacien.setLastName(result.getString("last_name"));
                pharmacien.setPhone(result.getString("phone"));
                pharmacienList.add(pharmacien);
            }
        }
        return pharmacienList;
    }
}
