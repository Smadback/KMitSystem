package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maik
 */
public class DBTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static boolean isTeamExisiting(String name) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from team where name='" + name + "'");
            resultSet.first();
            
            if(resultSet.getInt("count") > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "[" + DBTeamQueries.class.getName() + ":isTeamExisting] " + ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
    public static Team getTeam(String name) {
        Team team = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from team where name='" + name + "'");
            resultSet.first();
            
            String teamname = resultSet.getString("name");
            String tag = resultSet.getString("tag");
            User leader = new User(resultSet.getString("leader"));
            String password = resultSet.getString("password");
            Date create_date = resultSet.getDate("create_date");
            Statistics statistics = new Statistics(resultSet.getInt("goals"), resultSet.getInt("goals_conceded"), resultSet.getInt("wins"), 
                    resultSet.getInt("defeats"), resultSet.getInt("tournament_wins"), resultSet.getInt("tournament_participations"));

            team = new Team(teamname, tag, password, leader, statistics, create_date);
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        return team;
    }
    
    public static void createTeam(String name, String tag, String password, String leader) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            statement.execute("insert into team"
                        + "(name, tag, password, leader)"
                        + "VALUES ('" + name + "','" + tag + "','" + password + "','" + leader + "')");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static boolean editName(String teamname, String new_name) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET name = '" + new_name + "' WHERE name = '" + teamname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTeamQueries.class.getName() + ":editName");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamname: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTag(String teamname, String new_tag) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET tag = '" + new_tag + "' WHERE name = '" + teamname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTeamQueries.class.getName() + ":editTag");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamTag: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editPassword(String teamname, String new_password) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET password = '" + new_password + "' WHERE name = '" + teamname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTeamQueries.class.getName() + ":editPassword");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamPassword: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editLeader(String teamname, String new_leader) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET leader = '" + new_leader + "' WHERE name = '" + teamname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTeamQueries.class.getName() + ":editLeader");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editLeader: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static Boolean isTeamPasswordOK(String teamname, String password) {
        
        Boolean result = false;
        
         try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count "
                                        + "from team "
                                        + "where name='" + teamname + "'"
                                        + "and password='" + password + "'");
            
            resultSet.first();
           
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "isTeamPasswordOK: " + ex.getSQLState() + " " +ex.getMessage());
        }
        
         return result;
    }
    
    public static List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<Team>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT name, tag, leader, create_date FROM team");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                teams.add(new Team(resultSet.getString("name"), resultSet.getString("tag"), new User(resultSet.getString("leader")), resultSet.getDate("create_date")));
                resultSet.next();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUserQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teams;
     }
    
}
