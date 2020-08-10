package com.myride.common.utils;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.myride.common.constants.ProfileType;

@Converter(autoApply = true)
public class ProfileTypeConverter implements AttributeConverter<ProfileType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ProfileType profileType) {
		if (profileType == null) {
			return null;
		}
		return profileType.getCode();
	}

	@Override
	public ProfileType convertToEntityAttribute(Integer code) {
		if (code == null) {
			return null;
		}
		return Stream.of(ProfileType.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}