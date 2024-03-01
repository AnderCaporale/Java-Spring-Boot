package com.anderson.dslist.services;

import com.anderson.dslist.dto.GameDTO;
import com.anderson.dslist.dto.GameMinDTO;
import com.anderson.dslist.entities.Game;
import com.anderson.dslist.projections.GameMinProjection;
import com.anderson.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true) //Proriedade ACID (com apenas leitura, mais rapido)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
        
        //return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
    
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
        
        //return new GameDTO(result);
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
        
        //return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
