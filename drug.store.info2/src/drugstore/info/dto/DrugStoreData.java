package drugstore.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class DrugStoreData {
   private String storeRegion;
   private String storeName;
   private String storeNumber;
   private String storeAddr;
   private int storeMaskNumber;
}