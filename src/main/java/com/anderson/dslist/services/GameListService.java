package com.anderson.dslist.services;

import com.anderson.dslist.dto.GameListDTO;
import com.anderson.dslist.entities.GameList;
import com.anderson.dslist.projections.GameMinProjection;
import com.anderson.dslist.repositories.GameListRepository;
import com.anderson.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;
    
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
    
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> listResult = gameRepository.searchByList(listId);
        
        GameMinProjection obj = listResult.remove(sourceIndex);
        listResult.add(destinationIndex, obj);
        
        int min = Integer.min(sourceIndex, destinationIndex);
        int max = Integer.max(sourceIndex, destinationIndex);
        
        
        for(int i=min; i<max; i++){
            gameListRepository.updateBelongingPosition(listId, listResult.get(i).getId(), i);
        }
        
        
    }
}
