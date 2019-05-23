package nl.inholland.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ApiKey {

    @Id
    String key;

    public ApiKey(String key){
        this.key = key;
    }
}
