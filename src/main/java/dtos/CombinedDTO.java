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
    private String uselessFact;
    
    public  CombinedDTO(CatFactDTO  cfDTO,  pokeDTO pDTO, UselessFactDTO ufDTO){
        this.catFact = cfDTO.getText();
        this.pokemonName = pDTO.getName();
        this.uselessFact = ufDTO.getText();
    }
    
}