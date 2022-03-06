package nusiss.csf.server.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nusiss.csf.server.Repository.MongoDbRepo;
import nusiss.csf.server.model.favouriteFood;

@RequestMapping("/api/mongodb")
public class MongoDbController {

    @Autowired
    private MongoDbRepo mongodb;

    @GetMapping("{userId}")
    public ResponseEntity<String> getAllFavouriteFood(@RequestParam String userId){
        favouriteFood newff = new favouriteFood(1, "12345678", "tian tian", "fred" );
        System.out.println("checking");
        mongodb.save(newff);
        Optional<favouriteFood> ff = mongodb.findById(userId);
        if (ff.isPresent()){
        return ResponseEntity.ok(ff.get().toString());
        }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }
    
}
