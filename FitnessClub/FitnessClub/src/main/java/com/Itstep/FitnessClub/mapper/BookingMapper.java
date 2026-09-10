package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.dto.responce.BookingResponceDto;
import com.Itstep.FitnessClub.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookingMapper {

    BookingResponceDto bookingtoBookingResponceDto(Booking booking);

}
