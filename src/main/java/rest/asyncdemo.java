package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CatFactDTO;
import dtos.CombinedDTO;
import dtos.pokeDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

//This endpoint is  used  to demo asynchronous  fetching with Futures
@Path("asyncdemo")
public class asyncdemo {
    

    
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private ExecutorService executor  = Executors.newFixedThreadPool(4);
    
    
    Future<String> getDataAsync(String url) throws IOException{
        return executor.submit(()->{
            
            return  HttpUtils.fetchData(url);
        });
        
        }
        
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() throws IOException, InterruptedException, ExecutionException {
        
        
        
        
        Future<String>  catFuture = getDataAsync("https://cat-fact.herokuapp.com/facts/random");
        String catFact = catFuture.get();
        
        Future<String>  pokemonFuture = getDataAsync("https://pokeapi.co/api/v2/pokemon/1");
        String pokemon   =  pokemonFuture.get();
        
        CatFactDTO cfDTO = GSON.fromJson(catFact, CatFactDTO.class);
        pokeDTO pDTO = GSON.fromJson(pokemon,  pokeDTO.class);
        
        CombinedDTO combined  = new CombinedDTO(cfDTO, pDTO);
        
        return  GSON.toJson(combined);
        
    }
    

 
}
