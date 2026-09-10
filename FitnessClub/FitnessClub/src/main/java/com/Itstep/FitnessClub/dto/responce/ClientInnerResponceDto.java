package com.Itstep.FitnessClub.dto.responce;

/**
 * @author Daria Pevets
 **/
public record ClientInnerResponceDto(
        Long clientId,
        String fullName,
        String email,
        String phone
) {
}
