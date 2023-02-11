package org.commonModule.constant;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Embeddable
@NoArgsConstructor
public class StorageAddress {

    private String fullAddress;
    @Enumerated(EnumType.STRING)
    private Regions region;
    @Column(unique = true)
    private String city;

    public StorageAddress(String fullAddress, String region, String city) {
        this.fullAddress = fullAddress;
        this.region = Regions.valueOf(region);
        switch (this.region) {
            case AegeanRegion -> this.city = AegeanRegionCities.valueOf(city).name();
            case BlackSeaRegion -> this.city = BlackSeaRegionCities.valueOf(city).name();
            case CentralAnatoliaRegion -> CentralAnatoliaRegionCities.valueOf(city).name();
            case EasternAnatoliaRegion -> EasternAnatoliaRegionCities.valueOf(city).name();
            case MarmaraRegion -> this.city = MarmaraRegionCities.valueOf(city).name();
            case MediterraneanRegion -> this.city = MediterraneanRegionCities.valueOf(city).name();
            case Southeastern -> this.city = SoutheasternCities.valueOf(city).name();
        }
    }
}
