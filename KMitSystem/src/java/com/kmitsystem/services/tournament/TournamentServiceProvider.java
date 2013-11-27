package com.kmitsystem.services.tournament;

import com.kmitsystem.services.tournament.input.AddTeamInput;
import com.kmitsystem.services.tournament.input.CreateTournamentInput;
import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.services.tournament.input.SearchTournamentInput;
import com.kmitsystem.services.tournament.result.GetEverythingResult;
import com.kmitsystem.services.tournament.result.SearchTournamentResult;
import com.kmitsystem.services.tournament.validator.AddTeamValidator;
import com.kmitsystem.services.tournament.validator.CreateTournamentValidator;
import com.kmitsystem.services.tournament.validator.EditTournamentValidator;
import com.kmitsystem.services.tournament.validator.GetEverythingValidator;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.sql.Date;

/**
 * @author Malte
 */
public class TournamentServiceProvider {

    CreateTournamentValidator createTournamentValidator = new CreateTournamentValidator();
    AddTeamValidator addTeamValidator = new AddTeamValidator();
    GetEverythingValidator getEverythingValidator = new GetEverythingValidator();
    EditTournamentValidator editTournamentValidator = new EditTournamentValidator();

    public BaseResult createTournament(CreateTournamentInput input) {
        BaseResult result = new BaseResult();

        if (createTournamentValidator.validate(input)) {

            // prepare the input
            String name = input.getName();
            String password = input.getPassword();
            User leader = input.getLeader();
            String start_date = input.getStart_date();
            String end_date = input.getEnd_date();
            String nr_matchdays = input.getNr_matchdays();
            String venue = input.getVenue();
            String term_of_application = input.getTerm_of_application();

            // call the database
            //TODO:Date
            DBTournamentQueries.createTournament(name, password, leader, null, null, nr_matchdays, venue, null);
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public BaseResult addTeam(AddTeamInput input) {
        BaseResult result = new BaseResult();

        if (addTeamValidator.validate(input)) {
            // prepare the input
            String teamname = input.getTeamname();
            String tournamentname = input.getTournamentname();

            // call the database
            DBTeamTournamentQueries.addTeam(tournamentname, teamname);
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public GetEverythingResult getEverything(GetEverythingInput input) {
        GetEverythingResult result = new GetEverythingResult();

        if (getEverythingValidator.validate(input)) {
            // prepare the input
            String tournamentname = input.getTournamentname();

            // call the database
            result.setTournament(DBTournamentQueries.getTournament(tournamentname));
            result.setTeams(DBTeamTournamentQueries.getAllTeamsFromTournament(tournamentname));
            result.setMember(DBUserTournamentQueries.getAllUserFromTournament(tournamentname));
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    // no validation needed, because there are no false inputs
    public SearchTournamentResult searchTournament(SearchTournamentInput input) {

        SearchTournamentResult result = new SearchTournamentResult();

        // prepare the input
        String team_name = input.getTeam();
        String tournament_name = input.getTournament();
        String user_name = input.getUser();
        String month = input.getCreateMonth();
        Boolean running = input.getTournamentIsRunning();
        Boolean finished = input.getTournamentIsFinished();

        // call the database
        // search tournament
        if (tournament_name != null && !tournament_name.equals("")) {
            result.addTournament(DBTournamentQueries.getTournament(tournament_name));
        }

        // search team
        if (team_name != null && !team_name.equals("")) {
            result.addTournaments(DBTeamTournamentQueries.getAllTournamentsFromTeam(team_name));
        }

        // search user
        if (user_name != null && !user_name.equals("")) {
            result.addTournaments(DBUserTournamentQueries.getAllTournamentFromUser(user_name));
        }
        
        // search month
        if (month != null && !month.equals("")) {
            result.addTournaments(DBTournamentQueries.getTournamentsByMonth(month));
        }
        
        // search running
//        if (running) {
//            //TODO
//        }
//        
//        // search month
//        if (finished) {
//            //TODO
//        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public BaseResult editTournament(EditTournamentInput input) {
        BaseResult result = new BaseResult();

        if (editTournamentValidator.validate(input)) {
            // prepare the input
            String tournamentname = input.getTournamentname();
            String new_name = input.getNew_name();
            String new_password = input.getNew_password();
            String new_leader = input.getNew_leader();
            String new_venue = input.getNew_venue();
            int new_nr_matchdays = input.getNew_nr_matchdays();
            Date new_term_of_application = input.getNew_term_of_application();
            Date new_start_date = input.getNew_start_date();
            Date new_end_date = input.getNew_end_date();

            // call the database
            if (new_name != null) {
                DBTournamentQueries.editTournamentName(tournamentname, new_name);
            }
            if (new_password != null) {
                DBTournamentQueries.editTournamentPassword(tournamentname, new_password);
            }
            if (new_leader != null) {
                DBTournamentQueries.editTournamentLeader(tournamentname, new_leader);
            }
            if (new_venue != null) {
                DBTournamentQueries.editTournamentVenue(tournamentname, new_venue);
            }
            if (new_nr_matchdays <= 0) {
                DBTournamentQueries.editTournamentMatchdays(tournamentname, new_nr_matchdays);
            }
            if (new_term_of_application != null) {
                DBTournamentQueries.editTournamentTerm(tournamentname, new_term_of_application);
            }
            if (new_start_date != null) {
                DBTournamentQueries.editTournamentStart(tournamentname, new_start_date);
            }
            if (new_end_date != null) {
                DBTournamentQueries.editTournamentEnd(tournamentname, new_end_date);
            }
        }
        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

}
