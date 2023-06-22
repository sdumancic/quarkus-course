package org.agoncal.quarkus.jdbc;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Instant;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {
    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?,?,?,?)";
        artist.setId(Math.abs(new Random().nextLong()));
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, artist.getId());
            preparedStatement.setString(2, artist.getName());
            preparedStatement.setString(3, artist.getBio());
            preparedStatement.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            preparedStatement.executeUpdate();
        }
        connection.close();
    }

    public Artist findById(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "SELECT id, name, bio, created_date FROM t_artists WHERE ID = ?";
        Artist artist = new Artist();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                artist.setId(resultSet.getLong(1));
                artist.setName(resultSet.getString(2));
                artist.setBio(resultSet.getString(3));
                artist.setCreatedDate(resultSet.getTimestamp(4).toInstant());
            }
        }
        connection.close();
        return artist;
    }


}
