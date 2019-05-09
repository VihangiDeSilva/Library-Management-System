package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.DVD;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.WestminsterLibraryManager;

import java.util.List;

public class DVDController extends Controller{

        //create object
        WestminsterLibraryManager w2Manager=new WestminsterLibraryManager();

        //Method to prompt list of dvds
        public Result displayDVD(){

            List<DVD> dvds= w2Manager.displayDVD();
            JsonNode jsonNode = play.libs.Json.toJson(dvds);
            return ok(jsonNode).as("application/json");
        }

        //Method to Add DVD
        public Result addDVD(){
            try {
                JsonNode json = Json.parse(request().body().asText());
                int DISBN=Integer.parseInt(json.get("d_isbn").asText());
                String nameOfTheFilm= json.get("dvdName").asText();
                String languages= json.get("languages").asText();
                String subtitles= json.get("subtitles").asText();
                String nameOfTheProducer= json.get("nameOfTheProducer").asText();
                String actors=json.get("actors").asText();

                DVD dvd=new DVD(DISBN, nameOfTheFilm,null, languages, subtitles, nameOfTheProducer,actors);

                w2Manager.addDVD(dvd);
                return ok(Json.toJson("successfully added to the system.")).as("application/json");
            }catch (Exception e){
                return ok(Json.toJson(String.valueOf(e))).as("application/json");
            }

        }

    //Method to delete item
    public Result delete(){

        try{
            JsonNode json = Json.parse(request().body().asText());
            int isbn=Integer.parseInt(json.get("isbn").asText());


            int status1= w2Manager.deleteBook(isbn);
            int status2= w2Manager.deleteDvd(isbn);

            String message;
            if (status1==2){
                int freeSpace=100-w2Manager.book_list_size();

                message="Book successfully deleted. Available space : "+freeSpace;
            }else if (status2==1){
                int freeSpace=50-w2Manager.dvd_list_size();
                message="DVD successfully deleted. Available space : "+freeSpace;
            }else {
                int freeSpace=50-w2Manager.dvd_list_size();
                message="Successfully deleted. Available space : "+freeSpace;
            }
            return ok(Json.toJson(message)).as("application/json");
        }


        catch (Exception e){
            //return ok(Json.toJson(String.valueOf(e))).as("application/json");
            return ok(Json.toJson("Insert the ISBN")).as("application/json");
        }
    }





    }


