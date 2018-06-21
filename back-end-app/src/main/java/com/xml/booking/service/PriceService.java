package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.TPrice;
import com.xml.booking.repository.TPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    TPriceRepository priceRepository;

    public Float calculateFullPrice(Accomodation accomodation, Date startDate, Date endDate, int persons){

        LocalDate startLDate = LocalDate.parse(startDate.toString());
        LocalDate endLDate = LocalDate.parse(endDate.toString());

        float priceForOne = 0.0F;
        for (LocalDate date = startLDate; date.isBefore(endLDate); date = date.plusDays(1))
        {
            System.out.println("Cena za datum: "+date);
            Date dt = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            List<TPrice> priceValidForDay = priceRepository.findByStartDateBeforeAndEndDateAfter(dt, dt);
            if(priceValidForDay.size() == 0){
                dt =Date.from(date.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
                priceValidForDay = priceRepository.findByStartDateBeforeAndEndDateAfter(dt, dt);
            }

            if(priceValidForDay.size() == 0){
                dt = Date.from(date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
                priceValidForDay = priceRepository.findByStartDateBeforeAndEndDateAfter(dt, dt);
            }

            if(priceValidForDay.size() != 0){
                for(TPrice foundPrice: priceValidForDay){
                    for(TPrice accPrice: accomodation.getPrices()){
                        if(foundPrice.getId().equals(accPrice.getId())){
                            priceForOne += foundPrice.getValue();
                            break;
                        }
                    }
                }
            }else{
                System.out.println("Nema cene za datum: "+date);
                return null;
            }
        }

        System.out.println("Cena za jednog "+priceForOne);
        return priceForOne * persons;
    }
}
