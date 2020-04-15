/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author casper
 */
public class CombinedDTO {
    
    private String catFact;
    private String pokemonName;
    
    public  CombinedDTO(CatFactDTO  cfDTO,  pokeDTO pDTO){
        this.catFact = cfDTO.getText();
        this.pokemonName = pDTO.getName();
    }
    
}
