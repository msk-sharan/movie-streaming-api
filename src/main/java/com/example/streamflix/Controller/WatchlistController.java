package com.example.streamflix.Controller;


import com.example.streamflix.Model.DTO.WatchlistDto;
import com.example.streamflix.Model.Enums.WatchlistStatus;
import com.example.streamflix.Service.Watchlist.WatchlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {

    private final WatchlistService watchlistService;
    public WatchlistController(WatchlistService watchlistService){
        this.watchlistService=watchlistService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddToWatchlist (@RequestParam Long userId,
                                                        @RequestParam Long movieId,
                                                        @RequestParam WatchlistStatus status){
        WatchlistDto Added = watchlistService.addWatchlist(userId,movieId,status);
        return new ResponseEntity<>("Watchlist Added Successfully " , HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WatchlistDto>> getUserWatchlist (@PathVariable("userId") Long userId){
        List<WatchlistDto> watchlistDto = watchlistService.getById(userId);
        return new ResponseEntity<>(watchlistDto,HttpStatus.FOUND);
    }

    @DeleteMapping("/{userId}/{movieId}")
    public ResponseEntity<String> deleteWatchlist (@PathVariable Long userId , @PathVariable Long movieId){
        watchlistService.deleteById(userId,movieId);

        return ResponseEntity.ok("Movie removed Successfully from watchlist");
    }

    @PutMapping("/update")
    public ResponseEntity<?> UpdateWatchlistStatus (@RequestParam Long userId,
                                                    @RequestParam Long movieId,
                                                    @RequestParam WatchlistStatus status){
        WatchlistDto updated = watchlistService.updateWatchlistStatus(userId,movieId,status);
        return new ResponseEntity<>("Watchlist Status updated successfully",HttpStatus.OK);
    }
}
