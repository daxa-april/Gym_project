package com.Itstep.FitnessClub.dto.response;

/**
 * @author Daria Pevets
 **/
public record ClientInnerResponseDto(
        Long clientId,
        String fullName,
        String email,
        String phone
) {
}
